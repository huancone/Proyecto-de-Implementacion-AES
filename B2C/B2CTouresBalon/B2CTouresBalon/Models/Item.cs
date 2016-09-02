using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Models
{
    public class Item
    {
        public Producto Producto { get; set; } = new Producto();
        public int Cantidad { get; set; }
    }
}