(:: pragma bea:global-element-parameter parameter="$actualizarContraseniaClienteResponse1" element="ns1:ActualizarContraseniaClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ActualizarContraseniaClienteResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActContraseniaClienteRes/";

declare function xf:ActContraseniaClienteRes($actualizarContraseniaClienteResponse1 as element(ns1:ActualizarContraseniaClienteResponse))
    as element(ns0:ActualizarContraseniaClienteResponse) {
        <ns0:ActualizarContraseniaClienteResponse>
            <respuesta>{ data($actualizarContraseniaClienteResponse1/respuesta) }</respuesta>
        </ns0:ActualizarContraseniaClienteResponse>
};

declare variable $actualizarContraseniaClienteResponse1 as element(ns1:ActualizarContraseniaClienteResponse) external;

xf:ActContraseniaClienteRes($actualizarContraseniaClienteResponse1)
