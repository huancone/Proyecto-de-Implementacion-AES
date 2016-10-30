(:: pragma bea:global-element-parameter parameter="$consultarRankingEspectaculosVendidosProductoResponse1" element="ns1:ConsultarRankingEspectaculosVendidosProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarRankingEspectaculosVendidosProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarRnkEspecVenProdRes/";

declare function xf:ConsultarRnkEspecVenProdRes($consultarRankingEspectaculosVendidosProductoResponse1 as element(ns1:ConsultarRankingEspectaculosVendidosProductoResponse))
    as element(ns0:consultarRankingEspectaculosVendidosProductoResponse) {
        <ns0:consultarRankingEspectaculosVendidosProductoResponse>
            {
                for $tipo_espectaculo in $consultarRankingEspectaculosVendidosProductoResponse1/tipo_espectaculo
                return
                    <tipo_espectaculo>{ $tipo_espectaculo/@* , $tipo_espectaculo/node() }</tipo_espectaculo>
            }
        </ns0:consultarRankingEspectaculosVendidosProductoResponse>
};

declare variable $consultarRankingEspectaculosVendidosProductoResponse1 as element(ns1:ConsultarRankingEspectaculosVendidosProductoResponse) external;

xf:ConsultarRnkEspecVenProdRes($consultarRankingEspectaculosVendidosProductoResponse1)
