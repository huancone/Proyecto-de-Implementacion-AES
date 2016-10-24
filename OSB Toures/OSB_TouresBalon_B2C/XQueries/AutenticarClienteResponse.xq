(:: pragma bea:global-element-parameter parameter="$autenticarClienteResponse1" element="ns1:AutenticarClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:AutenticarClienteResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/AutenticarClienteResponse/";

declare function xf:AutenticarClienteResponse($autenticarClienteResponse1 as element(ns1:AutenticarClienteResponse))
    as element(ns0:AutenticarClienteResponse) {
        <ns0:AutenticarClienteResponse>
            <respuesta>{ data($autenticarClienteResponse1/respuesta) }</respuesta>
        </ns0:AutenticarClienteResponse>
};

declare variable $autenticarClienteResponse1 as element(ns1:AutenticarClienteResponse) external;

xf:AutenticarClienteResponse($autenticarClienteResponse1)
