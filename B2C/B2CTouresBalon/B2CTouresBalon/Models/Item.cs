using System;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Models
{
    [Serializable]
    public class Item
    {
        public Producto Producto { get; set; }
        public int Cantidad { get; set; }
    }
}