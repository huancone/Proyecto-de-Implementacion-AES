(:: pragma bea:global-element-parameter parameter="$consultarRankingCerradoOrdenes1" element="ns1:consultarRankingCerradoOrdenes" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarRankingCerradoOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarRnkCerradasOrdReq/";

declare function xf:ConsultarRnkCerradasOrdReq($consultarRankingCerradoOrdenes1 as element(ns1:consultarRankingCerradoOrdenes))
    as element(ns0:ConsultarRankingCerradoOrdenes) {
        <ns0:ConsultarRankingCerradoOrdenes>{ $consultarRankingCerradoOrdenes1/@* , $consultarRankingCerradoOrdenes1/node() }</ns0:ConsultarRankingCerradoOrdenes>
};

declare variable $consultarRankingCerradoOrdenes1 as element(ns1:consultarRankingCerradoOrdenes) external;

xf:ConsultarRnkCerradasOrdReq($consultarRankingCerradoOrdenes1)
