(:: pragma bea:global-element-parameter parameter="$actualizarContraseniaCliente1" element="ns0:ActualizarContraseniaCliente" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ActualizarContraseniaCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActContraseniaClienteReq/";

declare function xf:ActContraseniaClienteReq($actualizarContraseniaCliente1 as element(ns0:ActualizarContraseniaCliente))
    as element(ns1:ActualizarContraseniaCliente) {
        <ns1:ActualizarContraseniaCliente>
            <usuario>{ data($actualizarContraseniaCliente1/usuario) }</usuario>
            <contrasenia>{ data($actualizarContraseniaCliente1/contrasenia) }</contrasenia>
        </ns1:ActualizarContraseniaCliente>
};

declare variable $actualizarContraseniaCliente1 as element(ns0:ActualizarContraseniaCliente) external;

xf:ActContraseniaClienteReq($actualizarContraseniaCliente1)
