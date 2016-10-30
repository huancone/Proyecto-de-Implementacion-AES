(:: pragma bea:global-element-parameter parameter="$actualizarCliente1" element="ns0:actualizarCliente" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ActualizarCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActClienteReq/";

declare function xf:ActClienteReq($actualizarCliente1 as element(ns0:actualizarCliente))
    as element(ns1:ActualizarCliente) {
        <ns1:ActualizarCliente>
            <cliente>{ $actualizarCliente1/cliente/@* , $actualizarCliente1/cliente/node() }</cliente>
        </ns1:ActualizarCliente>
};

declare variable $actualizarCliente1 as element(ns0:actualizarCliente) external;

xf:ActClienteReq($actualizarCliente1)
