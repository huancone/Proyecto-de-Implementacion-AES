(:: pragma bea:global-element-parameter parameter="$consultarRangoCerradoOrdenesResponse1" element="ns0:ConsultarRangoCerradoOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarRangoCerradoOrdenesResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarRangoCerradoOrdRes/";

declare function xf:ConsultarRangoCerradoOrdRes($consultarRangoCerradoOrdenesResponse1 as element(ns0:ConsultarRangoCerradoOrdenesResponse))
    as element(ns1:consultarRangoCerradoOrdenesResponse) {
        <ns1:consultarRangoCerradoOrdenesResponse>
            <ordenes_cerradas>{ $consultarRangoCerradoOrdenesResponse1/ordenes_cerradas/@* , $consultarRangoCerradoOrdenesResponse1/ordenes_cerradas/node() }</ordenes_cerradas>
        </ns1:consultarRangoCerradoOrdenesResponse>
};

declare variable $consultarRangoCerradoOrdenesResponse1 as element(ns0:ConsultarRangoCerradoOrdenesResponse) external;

xf:ConsultarRangoCerradoOrdRes($consultarRangoCerradoOrdenesResponse1)
