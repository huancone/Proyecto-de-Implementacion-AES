using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace B2C_TouresBalon.Models
{

    public class Carrito
    {
        List<ItemCarrito> items;

        public bool AgregarProducto(ItemCarrito i)
        {
            try
            {
                items.Add(i);
            }
            catch (Exception)
            {
                return false;
            }

            return true;
        }

        public bool EliminarProducto(ItemCarrito i)
        {
            return true;
        }

    }
}