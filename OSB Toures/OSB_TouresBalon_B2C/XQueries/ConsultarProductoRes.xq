(:: pragma bea:global-element-parameter parameter="$consultarProductoResponse1" element="ns1:ConsultarProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarProductoResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarProductoRes/";

declare function xf:ConsultarProductoRes($consultarProductoResponse1 as element(ns1:ConsultarProductoResponse))
    as element(ns0:ConsultarProductoResponse) {
        <ns0:ConsultarProductoResponse>
            {
                for $productos in $consultarProductoResponse1/productos
                return
                    <productos>{ $productos/@* , $productos/node() }</productos>
            }
        </ns0:ConsultarProductoResponse>
};

declare variable $consultarProductoResponse1 as element(ns1:ConsultarProductoResponse) external;

xf:ConsultarProductoRes($consultarProductoResponse1)
