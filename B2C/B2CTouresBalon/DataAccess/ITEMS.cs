//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace DataAccess
{
    using System;
    using System.Collections.Generic;
    
    public partial class ITEMS
    {
        public decimal ITEMID { get; set; }
        public Nullable<decimal> PRODID { get; set; }
        public string PRODUCTNAME { get; set; }
        public string PARTNUM { get; set; }
        public Nullable<decimal> PRICE { get; set; }
        public Nullable<decimal> QUANTITY { get; set; }
        public decimal ORDID { get; set; }
    
        public virtual ORDERS ORDERS { get; set; }
    }
}
