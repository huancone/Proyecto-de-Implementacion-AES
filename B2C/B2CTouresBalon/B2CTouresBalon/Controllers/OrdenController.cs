using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net;
using System.ServiceModel;
using System.Web.Mvc;
using B2CTouresBalon.DAL.Security;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;
using Enyim.Caching;
using Enyim.Caching.Configuration;
using Enyim.Caching.Memcached;

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
            //    ord.estado = SrvProxyB2C.estadoOrden.VALIDACION;
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
            //o.estado = estadoOrden.VALIDACION   

            try
            {
                lstOrden = ordenes.ConsultarClientesOrdenes(currentUser.CustId.ToString(CultureInfo.InvariantCulture));

            }
            catch (FaultException<ConsultarClientesOrdenesFault> exf)
            {

                throw new Exception("Error al traer las ordenes " + exf.Detail.ConsultarClientesOrdenesFault1.mensaje);
            }
            catch (CommunicationException cex)
            {

                throw new CommunicationException("Error de conmunicacion " + cex.ToString());
            }


            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));
            //clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("192.168.99.100"), 32769));



            using (var ordencache = new MemcachedClient(clientConfiguration))
            {
                // se almacena en cache el listado de ordenes del cliente
                ordencache.Store(StoreMode.Set, "Orden-" + currentUser.UserName, lstOrden);
                //HttpContext.Session["ListaOrden"] = lstorden;

            }

            return View(lstOrden.ToList());
        }


        public ActionResult Cancelar(string idOrden)
        {
            var cancela = new ServiceProxyB2CClient();
            var rpta = new RespuestaGenerica();
            var valorcancela = new RespuestaCancelacionModel();
            var idOrdenes = new string[1] { idOrden };
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;

            if (currentUser == null) return View("Index");

            try
            {
                rpta = cancela.CancelarOrdenes(idOrdenes);

                var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
                clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));
                //clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("192.168.99.100"), 32769));
                using (var ordencache = new MemcachedClient(clientConfiguration))
                {
                    // se almacena en cache el listado de ordenes del cliente
                    ordencache.Remove("Order-" + currentUser.UserName);
                    //HttpContext.Session["ListaOrden"] = lstorden;

                }

            }
            catch (FaultException<CancelarOrdenesFault> exf)
            {
                valorcancela.respuesta = "Se presento un error al cancelar la orden " + idOrden + ". Intentelo más tarde (" + exf.Message + ")";
                return View("_Cancelar", valorcancela);
            }
            catch (Exception ex)
            {
                valorcancela.respuesta = "Se presento un error al cancelar la orden " + idOrden + ". Intentelo más tarde";
                return View("_Cancelar", valorcancela);
            }
            if (rpta == RespuestaGenerica.OK)
                valorcancela.respuesta = "Se cancelo la orden " + idOrden + " de forma exitosa";
            else
                valorcancela.respuesta = "Se presento un problema al cancelar la orden " + idOrden + ". Intentelo más tarde";

            return View("_Cancelar", valorcancela);
        }


        public ActionResult Detalle(string IdOrden)
        {
            var currentUser = System.Web.HttpContext.Current.User as CustomPrincipal;

            if (currentUser == null)
            {
                return View("Index");
            }
            var clientConfiguration = new MemcachedClientConfiguration { Protocol = MemcachedProtocol.Binary };
            clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("127.0.0.1"), 32768));
            //clientConfiguration.Servers.Add(new IPEndPoint(IPAddress.Parse("192.168.99.100"), 32769));
            // se recupera la informacion de la orden en cache

            using (var ordencache = new MemcachedClient(clientConfiguration))
            {
                var lstOrdenes = ordencache.Get<Orden>("Orden-" + currentUser.UserName);
                if (lstOrdenes == null) return View("Index");
                var lstItems = lstOrdenes.item;
                ViewBag.IdOrden = IdOrden;


                return View("_Detalle", lstItems.ToList());
            }
        }
    }
}