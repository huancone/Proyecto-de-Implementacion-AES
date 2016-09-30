using System;
using System.Collections.Generic;
using System.ServiceModel;
using System.Web.Mvc;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;
using Item = B2CTouresBalon.ServiceProxyB2C.Item;
using Enyim.Caching.Configuration;
using System.Net;
using Enyim.Caching.Memcached;
using Enyim.Caching;
using B2CTouresBalon.DAL.Security;
using System.Linq;

namespace B2CTouresBalon.Controllers
{
    public class OrdenController : Controller
    {
        // GET: Orden
        public ActionResult Index()
        {


            //for (int i=0;i<=10; i++)
            //{
            //    OrdenModel ord = new OrdenModel();
            //    ord.estatus = SrvProxyB2C.EstatusOrden.VALIDACION;
            //    ord.fechaOrden = DateTime.Now.AddDays(i);
            //    Random r = new Random(i);
            //    ord.id_orden = "ORD-" + (Math.Round(r.NextDouble()*10000,0)).ToString() ;

            //    ord.detalle = new List<SrvProxyB2C.Item>();

            //    double valsum = 0; ;
            //    for (int j = 0; j <= 3; j++)
            //    {
            //        SrvProxyB2C.Item item = new SrvProxyB2C.Item();
            //        item.id_item = "ITM-" + j.ToString();
            //        item.id_prod = j;
            //        item.nombre_prod = "Prod-" + j.ToString();
            //        item.part_num = "Part-" + j.ToString();
            //        item.cantidad = 1;

            //        item.precio = Math.Round( r.NextDouble()*100000,0);
            //        valsum = valsum + item.precio;
            //        ord.detalle.Add(item);

            //    }
            //    ord.precio = valsum;
            //    lstordenes.Add(ord);
            //}

            IEnumerable<Orden> lstOrden;
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;
            var ordenes = new ServiceProxyB2CClient();
            //Orden o = new Orden();
            //o.estatus = EstatusOrden.VALIDACION   

            try
            {
                 lstOrden =ordenes.ConsultarClientesOrdenes(currentUser.CustId.ToString());

            }
            catch (FaultException<ConsultarClientesOrdenesFault> exf )
            {

                throw new Exception("Error al traer las ordenes " + exf.Detail.ConsultarClientesOrdenesFault1.mensaje);
            }
            catch (CommunicationException cex)
            {

                throw new CommunicationException("Error de conmunicacion " + cex.ToString());
            }
             
             
            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            //clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("192.168.99.100"), 32769));
            


            using (var ordencache = new MemcachedClient(clientConfiguration))
            {
                // se almacena en cache el listado de ordenes del cliente
                ordencache.Store(StoreMode.Set, "Orden-" + currentUser.UserName, lstOrden);
                //HttpContext.Session["ListaOrden"] = lstorden;
                
            }

            return View(lstOrden.ToList());
        }


        public ActionResult  Cancelar(string idOrden)
        {
            var cancela = new ServiceProxyB2CClient(); 
            var rpta = new RespuestaGenerica();
            var valorcancela = new RespuestaCancelacionModel();
            var idOrdenes = new string[1] { idOrden } ;

            try
            {
                rpta = cancela.CancelarOrdenes(idOrdenes);
            }
            catch ( FaultException<CancelarOrdenesFault> exf )
            {
                valorcancela.respuesta = "Se presento un error al cancelar la orden " + idOrden + ". Intentelo más tarde (" + exf.Message + ")"   ;
                return View("_Cancelar", valorcancela);
            }
            catch (Exception  ex)
            {
                valorcancela.respuesta = "Se presento un error al cancelar la orden " + idOrden + ". Intentelo más tarde";
                return View("_Cancelar", valorcancela);
            }
            if (rpta == RespuestaGenerica.OK)
                valorcancela.respuesta  = "Se cancelo la orden " + idOrden + " de forma exitosa";
            else
                valorcancela.respuesta  = "Se presento un problema al cancelar la orden " + idOrden + ". Intentelo más tarde";

            return View("_Cancelar", valorcancela);
        }


        public ActionResult Detalle (string IdOrden )
        {
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;

            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            //clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("192.168.99.100"), 32769));
            // se recupera la informacion de la orden en cache
            List<Orden> lstOrdenes;
            using (var ordencache = new MemcachedClient(clientConfiguration))
            {
                lstOrdenes = ((IEnumerable<Orden>)ordencache.Get("Orden-" + currentUser.UserName)).ToList();
            }

               // lstordenes =(List<OrdenModel>)HttpContext.Session["ListaOrden"] ;

            // se filtra el detalle de la orden
            var lstItems = lstOrdenes.Find(ord => ord.id_orden == IdOrden).item;  
            ViewBag.IdOrden = IdOrden;
         

            return View("_Detalle", lstItems.ToList()); 
        }
    }
}