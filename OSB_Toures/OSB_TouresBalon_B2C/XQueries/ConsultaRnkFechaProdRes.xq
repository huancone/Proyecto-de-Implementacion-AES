(:: pragma bea:global-element-parameter parameter="$consultarRankingFechaProductoResponse1" element="ns1:ConsultarRankingFechaProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarRankingFechaProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultaRnkFechaProdRes/";

declare function xf:ConsultaRnkFechaProdRes($consultarRankingFechaProductoResponse1 as element(ns1:ConsultarRankingFechaProductoResponse))
    as element(ns0:consultarRankingFechaProductoResponse) {
        <ns0:consultarRankingFechaProductoResponse>
            {
                for $productos in $consultarRankingFechaProductoResponse1/productos
                return
                    <productos>{ $productos/@* , $productos/node() }</productos>
            }
        </ns0:consultarRankingFechaProductoResponse>
};

declare variable $consultarRankingFechaProductoResponse1 as element(ns1:ConsultarRankingFechaProductoResponse) external;

xf:ConsultaRnkFechaProdRes($consultarRankingFechaProductoResponse1)
