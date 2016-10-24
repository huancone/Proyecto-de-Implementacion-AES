(:: pragma bea:global-element-parameter parameter="$crearOrdenesResponse1" element="ns1:CrearOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:CrearOrdenesResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/CrearOrdenesRes/";

declare function xf:CrearOrdenesRes($crearOrdenesResponse1 as element(ns1:CrearOrdenesResponse))
    as element(ns0:CrearOrdenesResponse) {
        <ns0:CrearOrdenesResponse>
            <respuesta>{ $crearOrdenesResponse1/respuesta/@* , $crearOrdenesResponse1/respuesta/node() }</respuesta>
        </ns0:CrearOrdenesResponse>
};

declare variable $crearOrdenesResponse1 as element(ns1:CrearOrdenesResponse) external;

xf:CrearOrdenesRes($crearOrdenesResponse1)
