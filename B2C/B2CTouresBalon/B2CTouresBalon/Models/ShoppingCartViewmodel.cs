using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2CTouresBalon.ServiceProxyB2C;

namespace B2CTouresBalon.Models
{
    public class ShoppingCartViewmodel
    {
        public List<ShoppingCartItem> Items { get; set; }

        public void AddItem(ShoppingCartItem i)
        {
            var itemFound = false;
            foreach (var item in Items.Where(item => i.Producto == item.Producto))
            {
                item.Quantity += i.Quantity;
                itemFound = true;
            }
            if(!itemFound) { Items.Add(i);}
        }

        public void DeleteItem(ShoppingCartItem i)
        {
            var itemFound = false;
            foreach (var item in Items.Where(item => i.Producto == item.Producto))
            {
                if (item.Quantity >= i.Quantity)
                {
                    item.Quantity = item.Quantity - i.Quantity;
                }
                else
                {
                    item.Quantity = 0;
                }
                itemFound = true;
            }
            if (!itemFound) { Items.Add(i); }
        }
    }

    public class ShoppingCartItem
    {
        public Producto Producto { get; set; }
        public int Quantity { get; set; }
    }
}