(:: pragma bea:global-element-parameter parameter="$consultarCampaniaProductoResponse1" element="ns1:ConsultarCampaniaProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarCampaniaProductoResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarCampaniaResponse/";

declare function xf:ConsultarCampaniaResponse($consultarCampaniaProductoResponse1 as element(ns1:ConsultarCampaniaProductoResponse))
    as element(ns0:ConsultarCampaniaProductoResponse) {
        <ns0:ConsultarCampaniaProductoResponse>
            {
                for $productos in $consultarCampaniaProductoResponse1/productos
                return
                    <productos>{ $productos/@* , $productos/node() }</productos>
            }
        </ns0:ConsultarCampaniaProductoResponse>
};

declare variable $consultarCampaniaProductoResponse1 as element(ns1:ConsultarCampaniaProductoResponse) external;

xf:ConsultarCampaniaResponse($consultarCampaniaProductoResponse1)
