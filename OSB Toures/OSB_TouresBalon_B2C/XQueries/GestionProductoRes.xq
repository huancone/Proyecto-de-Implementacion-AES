(:: pragma bea:global-element-parameter parameter="$gestionProductoResponse1" element="ns1:GestionProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:gestionProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/GestionProductoRes/";

declare function xf:GestionProductoRes($gestionProductoResponse1 as element(ns1:GestionProductoResponse))
    as element(ns0:gestionProductoResponse) {
        <ns0:gestionProductoResponse>
            <gestion_producto_reponse>{ $gestionProductoResponse1/gestion_producto_reponse/@* , $gestionProductoResponse1/gestion_producto_reponse/node() }</gestion_producto_reponse>
        </ns0:gestionProductoResponse>
};

declare variable $gestionProductoResponse1 as element(ns1:GestionProductoResponse) external;

xf:GestionProductoRes($gestionProductoResponse1)
