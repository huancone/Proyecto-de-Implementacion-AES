(:: pragma bea:global-element-parameter parameter="$consultarRangoCerradoOrdenes1" element="ns1:consultarRangoCerradoOrdenes" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarRangoCerradoOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarRangoCerradoOrdReq/";

declare function xf:ConsultarRangoCerradoOrdReq($consultarRangoCerradoOrdenes1 as element(ns1:consultarRangoCerradoOrdenes))
    as element(ns0:ConsultarRangoCerradoOrdenes) {
        <ns0:ConsultarRangoCerradoOrdenes>
            <fecha_inicial>{ data($consultarRangoCerradoOrdenes1/fecha_inicial) }</fecha_inicial>
            <fecha_final>{ data($consultarRangoCerradoOrdenes1/fecha_final) }</fecha_final>
        </ns0:ConsultarRangoCerradoOrdenes>
};

declare variable $consultarRangoCerradoOrdenes1 as element(ns1:consultarRangoCerradoOrdenes) external;

xf:ConsultarRangoCerradoOrdReq($consultarRangoCerradoOrdenes1)
