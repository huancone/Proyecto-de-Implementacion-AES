(:: pragma bea:global-element-parameter parameter="$actualizarClienteResponse1" element="ns1:ActualizarClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:actualizarClienteResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActClienteRes/";

declare function xf:ActClienteRes($actualizarClienteResponse1 as element(ns1:ActualizarClienteResponse))
    as element(ns0:actualizarClienteResponse) {
        <ns0:actualizarClienteResponse>
            <respuesta>{ data($actualizarClienteResponse1/respuesta) }</respuesta>
        </ns0:actualizarClienteResponse>
};

declare variable $actualizarClienteResponse1 as element(ns1:ActualizarClienteResponse) external;

xf:ActClienteRes($actualizarClienteResponse1)
