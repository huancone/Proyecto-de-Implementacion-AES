(:: pragma bea:global-element-parameter parameter="$consultarRankingAbiertasOrdenesResponse1" element="ns0:ConsultarRankingAbiertasOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarRankingAbiertasOrdenesResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/COnsultarRnkAbiertasOrdRes/";

declare function xf:COnsultarRnkAbiertasOrdRes($consultarRankingAbiertasOrdenesResponse1 as element(ns0:ConsultarRankingAbiertasOrdenesResponse))
    as element(ns1:consultarRankingAbiertasOrdenesResponse) {
        <ns1:consultarRankingAbiertasOrdenesResponse>
            {
                for $ordenes in $consultarRankingAbiertasOrdenesResponse1/ordenes
                return
                    <ordenes>{ $ordenes/@* , $ordenes/node() }</ordenes>
            }
        </ns1:consultarRankingAbiertasOrdenesResponse>
};

declare variable $consultarRankingAbiertasOrdenesResponse1 as element(ns0:ConsultarRankingAbiertasOrdenesResponse) external;

xf:COnsultarRnkAbiertasOrdRes($consultarRankingAbiertasOrdenesResponse1)
