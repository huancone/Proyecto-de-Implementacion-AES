(:: pragma bea:global-element-parameter parameter="$consultarPorEspectaculoProductoResponse1" element="ns1:ConsultarPorEspectaculoProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarPorEspectaculoProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/consultarPorEspecProdRes/";

declare function xf:consultarPorEspecProdRes($consultarPorEspectaculoProductoResponse1 as element(ns1:ConsultarPorEspectaculoProductoResponse))
    as element(ns0:consultarPorEspectaculoProductoResponse) {
        <ns0:consultarPorEspectaculoProductoResponse>
            {
                for $productos in $consultarPorEspectaculoProductoResponse1/productos
                return
                    <productos>{ $productos/@* , $productos/node() }</productos>
            }
        </ns0:consultarPorEspectaculoProductoResponse>
};

declare variable $consultarPorEspectaculoProductoResponse1 as element(ns1:ConsultarPorEspectaculoProductoResponse) external;

xf:consultarPorEspecProdRes($consultarPorEspectaculoProductoResponse1)
