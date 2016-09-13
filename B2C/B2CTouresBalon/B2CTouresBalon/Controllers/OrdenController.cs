using System;
using System.Collections.Generic;
using System.ServiceModel;
using System.Web.Mvc;
using B2CTouresBalon.Models;
using B2CTouresBalon.ServiceProxyB2C;
using Item = B2CTouresBalon.ServiceProxyB2C.Item;

namespace B2CTouresBalon.Controllers
{
    public class OrdenController : Controller
    {
        List<OrdenModel> lstordenes = new List<OrdenModel>();
        // GET: Orden
        public ActionResult Index(string idcliente)
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


            var ordenes = new ServiceProxyB2CClient();
            var lstorden = ordenes.ConsultarClientesOrdenes(idcliente);

            
         
           

            HttpContext.Session["ListaOrden"] = lstorden;


            return View(lstorden);
        }


        public ActionResult  Cancelar(string idOrden)
        {
            var cancela = new ServiceProxyB2CClient();
            var rpta = new RespuestaGenerica();
            var valorcancela = new RespuestaCancelacionModel();
            var IdOrdenes = new string[1] { idOrden } ;

            try
            {
                rpta = cancela.CancelarOrdenes(IdOrdenes);
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
            lstordenes =(List<OrdenModel>)HttpContext.Session["ListaOrden"] ;


            var LstItems = lstordenes.Find(ord => ord.id_orden == IdOrden).item;  
            ViewBag.IdOrden = IdOrden;
         

            return View("_Detalle", LstItems); 
        }
    }
}