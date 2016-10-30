(:: pragma bea:global-element-parameter parameter="$actualizarContraseniaClienteResponse1" element="ns1:ActualizarContraseniaClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:actualizarContraseniaClienteResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/actualizarContraseniaClienteRes/";

declare function xf:actualizarContraseniaClienteRes($actualizarContraseniaClienteResponse1 as element(ns1:ActualizarContraseniaClienteResponse))
    as element(ns0:actualizarContraseniaClienteResponse) {
        <ns0:actualizarContraseniaClienteResponse>
            <respuesta>{ data($actualizarContraseniaClienteResponse1/respuesta) }</respuesta>
        </ns0:actualizarContraseniaClienteResponse>
};

declare variable $actualizarContraseniaClienteResponse1 as element(ns1:ActualizarContraseniaClienteResponse) external;

xf:actualizarContraseniaClienteRes($actualizarContraseniaClienteResponse1)
