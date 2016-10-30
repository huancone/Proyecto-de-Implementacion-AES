(:: pragma bea:global-element-parameter parameter="$registrarCliente1" element="ns0:RegistrarCliente" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:RegistrarCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/RegClienteReq/";

declare function xf:RegClienteReq($registrarCliente1 as element(ns0:RegistrarCliente))
    as element(ns1:RegistrarCliente) {
        <ns1:RegistrarCliente>
            <cliente>{ $registrarCliente1/cliente/@* , $registrarCliente1/cliente/node() }</cliente>
        </ns1:RegistrarCliente>
};

declare variable $registrarCliente1 as element(ns0:RegistrarCliente) external;

xf:RegClienteReq($registrarCliente1)
