(:: pragma bea:global-element-parameter parameter="$autenticarCliente" element="ns0:AutenticarCliente" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:AutenticarCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_B2C/XQueries/XQueryAutenticarClientes/";

declare function xf:XQueryAutenticarClientes($autenticarCliente as element(ns0:AutenticarCliente))
    as element(ns1:AutenticarCliente) {
        <ns1:AutenticarCliente>
            <usuario>{ data($autenticarCliente/usuario) }</usuario>
            <contrasenia>{ data($autenticarCliente/contrasenia) }</contrasenia>
        </ns1:AutenticarCliente>
};

declare variable $autenticarCliente as element(ns0:AutenticarCliente) external;

xf:XQueryAutenticarClientes($autenticarCliente)