using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2CTouresBalon.Models;
using System.ServiceModel;

namespace B2CTouresBalon.Controllers
{
    public class OrdenController : Controller
    {
        List<Models.OrdenModel> lstordenes = new List<OrdenModel>();
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




            HttpContext.Session["ListaOrden"] = lstordenes;


            return View(lstordenes);
        }


        public ActionResult  Cancelar(string idOrden)
        {
            ServiceProxyB2C.ServiceProxyB2CClient cancela = new ServiceProxyB2C.ServiceProxyB2CClient();
            ServiceProxyB2C.RespuestaGenerica rpta = new ServiceProxyB2C.RespuestaGenerica();
            RespuestaCancelacionModel valorcancela = new Models.RespuestaCancelacionModel();
            string[] IdOrdenes = new string[1] { idOrden } ;

            try
            {
                rpta = cancela.CancelarOrdenes(IdOrdenes);
            }
            catch ( FaultException<ServiceProxyB2C.CancelarOrdenesFault> exf )
            {
                valorcancela.respuesta = "Se presento un error al cancelar la orden " + idOrden + ". Intentelo más tarde (" + exf.Message + ")"   ;
                return View("_Cancelar", valorcancela);
            }
            catch (Exception  ex)
            {
                valorcancela.respuesta = "Se presento un error al cancelar la orden " + idOrden + ". Intentelo más tarde";
                return View("_Cancelar", valorcancela);
            }
            if (rpta == ServiceProxyB2C.RespuestaGenerica.OK)
                valorcancela.respuesta  = "Se cancelo la orden " + idOrden + " de forma exitosa";
            else
                valorcancela.respuesta  = "Se presento un problema al cancelar la orden " + idOrden + ". Intentelo más tarde";

            return View("_Cancelar", valorcancela);
        }


        public ActionResult Detalle (string IdOrden )
        {
            lstordenes =(List<OrdenModel>)HttpContext.Session["ListaOrden"] ;


            List<ServiceProxyB2C.Item> LstItems = lstordenes.Find(ord => ord.id_orden == IdOrden).detalle;  
            ViewBag.IdOrden = IdOrden;
         

            return View("_Detalle", LstItems); 
        }
    }
}