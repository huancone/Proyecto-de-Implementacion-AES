(:: pragma bea:global-element-parameter parameter="$actualizarContraseniaCliente1" element="ns0:actualizarContraseniaCliente" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ActualizarContraseniaCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/actualizarContraseniaClienteReq/";

declare function xf:actualizarContraseniaClienteReq($actualizarContraseniaCliente1 as element(ns0:actualizarContraseniaCliente))
    as element(ns1:ActualizarContraseniaCliente) {
        <ns1:ActualizarContraseniaCliente>
            <usuario>{ data($actualizarContraseniaCliente1/usuario) }</usuario>
            <contrasenia>{ data($actualizarContraseniaCliente1/contrasenia) }</contrasenia>
        </ns1:ActualizarContraseniaCliente>
};

declare variable $actualizarContraseniaCliente1 as element(ns0:actualizarContraseniaCliente) external;

xf:actualizarContraseniaClienteReq($actualizarContraseniaCliente1)
