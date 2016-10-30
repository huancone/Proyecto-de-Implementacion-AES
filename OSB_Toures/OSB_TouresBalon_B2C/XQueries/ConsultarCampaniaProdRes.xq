(:: pragma bea:global-element-parameter parameter="$consultarCampaniaProductoResponse1" element="ns1:ConsultarCampaniaProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarCampaniaProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarCampaniaProdRes/";

declare function xf:ConsultarCampaniaProdRes($consultarCampaniaProductoResponse1 as element(ns1:ConsultarCampaniaProductoResponse))
    as element(ns0:consultarCampaniaProductoResponse) {
        <ns0:consultarCampaniaProductoResponse>
            {
                for $productos in $consultarCampaniaProductoResponse1/productos
                return
                    <productos>{ $productos/@* , $productos/node() }</productos>
            }
        </ns0:consultarCampaniaProductoResponse>
};

declare variable $consultarCampaniaProductoResponse1 as element(ns1:ConsultarCampaniaProductoResponse) external;

xf:ConsultarCampaniaProdRes($consultarCampaniaProductoResponse1)
