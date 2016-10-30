(:: pragma bea:global-element-parameter parameter="$consultarPorEspectaculoProducto1" element="ns0:consultarPorEspectaculoProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarPorEspectaculoProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/consultarPorEspecProdReq/";

declare function xf:consultarPorEspecProdReq($consultarPorEspectaculoProducto1 as element(ns0:consultarPorEspectaculoProducto))
    as element(ns1:ConsultarPorEspectaculoProducto) {
        <ns1:ConsultarPorEspectaculoProducto>
            <espectaculo>{ data($consultarPorEspectaculoProducto1/espectaculo) }</espectaculo>
        </ns1:ConsultarPorEspectaculoProducto>
};

declare variable $consultarPorEspectaculoProducto1 as element(ns0:consultarPorEspectaculoProducto) external;

xf:consultarPorEspecProdReq($consultarPorEspectaculoProducto1)
