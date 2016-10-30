(:: pragma bea:global-element-parameter parameter="$consultarRankingCerradoOrdenesResponse1" element="ns0:ConsultarRankingCerradoOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarRankingCerradoOrdenesResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarRnkCerradasOrdRes/";

declare function xf:ConsultarRnkCerradasOrdRes($consultarRankingCerradoOrdenesResponse1 as element(ns0:ConsultarRankingCerradoOrdenesResponse))
    as element(ns1:consultarRankingCerradoOrdenesResponse) {
        <ns1:consultarRankingCerradoOrdenesResponse>
            {
                for $ordenes in $consultarRankingCerradoOrdenesResponse1/ordenes
                return
                    <ordenes>{ $ordenes/@* , $ordenes/node() }</ordenes>
            }
        </ns1:consultarRankingCerradoOrdenesResponse>
};

declare variable $consultarRankingCerradoOrdenesResponse1 as element(ns0:ConsultarRankingCerradoOrdenesResponse) external;

xf:ConsultarRnkCerradasOrdRes($consultarRankingCerradoOrdenesResponse1)
