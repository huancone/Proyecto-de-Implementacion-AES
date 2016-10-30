(:: pragma bea:global-element-parameter parameter="$cancelarOrdenesResponse1" element="ns1:CancelarOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:CancelarOrdenesResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/CancelarOrdenesRes/";

declare function xf:CancelarOrdenesRes($cancelarOrdenesResponse1 as element(ns1:CancelarOrdenesResponse))
    as element(ns0:CancelarOrdenesResponse) {
        <ns0:CancelarOrdenesResponse>
            <respuesta>{ data($cancelarOrdenesResponse1/respuesta) }</respuesta>
        </ns0:CancelarOrdenesResponse>
};

declare variable $cancelarOrdenesResponse1 as element(ns1:CancelarOrdenesResponse) external;

xf:CancelarOrdenesRes($cancelarOrdenesResponse1)
