<?xml version="1.0" encoding="UTF-8"?>
<con:xqueryEntry xmlns:con="http://www.bea.com/wli/sb/resources/config">
    <con:xquery>(:: pragma bea:global-element-parameter parameter="$autenticarClienteResponse" element="ns1:AutenticarClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:AutenticarClienteResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_B2C/XQueries/AutenticarClientesRes/";

declare function xf:AutenticarClientesRes($autenticarClienteResponse as element(ns1:AutenticarClienteResponse))
    as element(ns0:AutenticarClienteResponse) {
        &lt;ns0:AutenticarClienteResponse>
            &lt;respuesta>{ data($autenticarClienteResponse/respuesta) }&lt;/respuesta>
        &lt;/ns0:AutenticarClienteResponse>
};

declare variable $autenticarClienteResponse as element(ns1:AutenticarClienteResponse) external;

xf:AutenticarClientesRes($autenticarClienteResponse)</con:xquery>
    <con:dependency location="../WSDLS/ClientesTouresBalon.wsdl">
        <con:wsdl ref="OSB_B2C/WSDLS/ClientesTouresBalon"/>
    </con:dependency>
    <con:dependency location="../WSDLS/ServiceProxyB2C.wsdl">
        <con:wsdl ref="OSB_B2C/WSDLS/ServiceProxyB2C"/>
    </con:dependency>
</con:xqueryEntry>