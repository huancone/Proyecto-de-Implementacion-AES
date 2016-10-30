(:: pragma bea:global-element-parameter parameter="$actualizarEstatusCliente1" element="ns0:actualizarEstatusCliente" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ActualizarEstatusCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ActualizarStatusClienteReq/";

declare function xf:ActualizarStatusClienteReq($actualizarEstatusCliente1 as element(ns0:actualizarEstatusCliente))
    as element(ns1:ActualizarEstatusCliente) {
        <ns1:ActualizarEstatusCliente>
            <id_cliente>{ data($actualizarEstatusCliente1/id_cliente) }</id_cliente>
            <estatus>{ data($actualizarEstatusCliente1/estatus) }</estatus>
        </ns1:ActualizarEstatusCliente>
};

declare variable $actualizarEstatusCliente1 as element(ns0:actualizarEstatusCliente) external;

xf:ActualizarStatusClienteReq($actualizarEstatusCliente1)
