(:: pragma bea:global-element-parameter parameter="$consultarOrdenes1" element="ns1:consultarOrdenes" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarOrdenesReq/";

declare function xf:ConsultarOrdenesReq($consultarOrdenes1 as element(ns1:consultarOrdenes))
    as element(ns0:ConsultarOrdenes) {
        <ns0:ConsultarOrdenes>
            <criterios>{ $consultarOrdenes1/criterios/@* , $consultarOrdenes1/criterios/node() }</criterios>
        </ns0:ConsultarOrdenes>
};

declare variable $consultarOrdenes1 as element(ns1:consultarOrdenes) external;

xf:ConsultarOrdenesReq($consultarOrdenes1)
