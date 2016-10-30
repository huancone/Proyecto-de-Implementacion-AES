(:: pragma bea:global-element-parameter parameter="$actualizarEstatusClienteResponse1" element="ns1:ActualizarEstatusClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:actualizarEstatusClienteResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActualizarStatusClienteRes/";

declare function xf:ActualizarStatusClienteRes($actualizarEstatusClienteResponse1 as element(ns1:ActualizarEstatusClienteResponse))
    as element(ns0:actualizarEstatusClienteResponse) {
        <ns0:actualizarEstatusClienteResponse>
            <respuesta>{ data($actualizarEstatusClienteResponse1/respuesta) }</respuesta>
        </ns0:actualizarEstatusClienteResponse>
};

declare variable $actualizarEstatusClienteResponse1 as element(ns1:ActualizarEstatusClienteResponse) external;

xf:ActualizarStatusClienteRes($actualizarEstatusClienteResponse1)
