(:: pragma bea:global-element-parameter parameter="$autenticarCliente1" element="ns0:AutenticarCliente" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:AutenticarCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/AutenticarClientRequest/";

declare function xf:AutenticarClientRequest($autenticarCliente1 as element(ns0:AutenticarCliente))
    as element(ns1:AutenticarCliente) {
        <ns1:AutenticarCliente>
            <usuario>{ data($autenticarCliente1/usuario) }</usuario>
            <contrasenia>{ data($autenticarCliente1/contrasenia) }</contrasenia>
        </ns1:AutenticarCliente>
};

declare variable $autenticarCliente1 as element(ns0:AutenticarCliente) external;

xf:AutenticarClientRequest($autenticarCliente1)
