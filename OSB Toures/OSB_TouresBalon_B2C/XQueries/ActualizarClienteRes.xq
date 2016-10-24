(:: pragma bea:global-element-parameter parameter="$actualizarClienteResponse1" element="ns1:ActualizarClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ActualizarClienteResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActualizarClienteRes/";

declare function xf:ActualizarClienteRes($actualizarClienteResponse1 as element(ns1:ActualizarClienteResponse))
    as element(ns0:ActualizarClienteResponse) {
        <ns0:ActualizarClienteResponse>
            <respuesta>{ data($actualizarClienteResponse1/respuesta) }</respuesta>
        </ns0:ActualizarClienteResponse>
};

declare variable $actualizarClienteResponse1 as element(ns1:ActualizarClienteResponse) external;

xf:ActualizarClienteRes($actualizarClienteResponse1)
