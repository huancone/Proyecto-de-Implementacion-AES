(:: pragma bea:global-element-parameter parameter="$gestionProducto1" element="ns0:gestionProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:GestionProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/GestionProductoReq/";

declare function xf:GestionProductoReq($gestionProducto1 as element(ns0:gestionProducto))
    as element(ns1:GestionProducto) {
        <ns1:GestionProducto>
            <tipo_operacion>{ data($gestionProducto1/tipo_operacion) }</tipo_operacion>
            <producto>{ $gestionProducto1/producto/@* , $gestionProducto1/producto/node() }</producto>
        </ns1:GestionProducto>
};

declare variable $gestionProducto1 as element(ns0:gestionProducto) external;

xf:GestionProductoReq($gestionProducto1)
