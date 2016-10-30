xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$consultarRankingAbiertasOrdenes1" element="ns1:consultarRankingAbiertasOrdenes" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarRankingAbiertasOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/COnsultarRnkAbiertasOrdReq/";
declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";

declare function xf:COnsultarRnkAbiertasOrdReq($consultarRankingAbiertasOrdenes1 as element(ns1:consultarRankingAbiertasOrdenes))
    as element(ns0:ConsultarRankingAbiertasOrdenes) {
        <ns0:ConsultarRankingAbiertasOrdenes/>
};

declare variable $consultarRankingAbiertasOrdenes1 as element(ns1:consultarRankingAbiertasOrdenes) external;

xf:COnsultarRnkAbiertasOrdReq($consultarRankingAbiertasOrdenes1)
