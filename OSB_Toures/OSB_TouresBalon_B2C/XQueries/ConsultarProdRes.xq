(:: pragma bea:global-element-parameter parameter="$consultarProductoResponse1" element="ns1:ConsultarProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarProdRes/";

declare function xf:ConsultarProdRes($consultarProductoResponse1 as element(ns1:ConsultarProductoResponse))
    as element(ns0:consultarProductoResponse) {
        <ns0:consultarProductoResponse>
            {
                for $productos in $consultarProductoResponse1/productos
                return
                    <productos>{ $productos/@* , $productos/node() }</productos>
            }
        </ns0:consultarProductoResponse>
};

declare variable $consultarProductoResponse1 as element(ns1:ConsultarProductoResponse) external;

xf:ConsultarProdRes($consultarProductoResponse1)
