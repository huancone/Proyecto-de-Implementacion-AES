(:: pragma bea:global-element-parameter parameter="$consultarPorIdentificacionCliente1" element="ns0:consultarPorIdentificacionCliente" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarPorIdentificacionCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarPorIdClienteReq/";

declare function xf:ConsultarPorIdClienteReq($consultarPorIdentificacionCliente1 as element(ns0:consultarPorIdentificacionCliente))
    as element(ns1:ConsultarPorIdentificacionCliente) {
        <ns1:ConsultarPorIdentificacionCliente>
            <id_cliente>{ data($consultarPorIdentificacionCliente1/id_cliente) }</id_cliente>
        </ns1:ConsultarPorIdentificacionCliente>
};

declare variable $consultarPorIdentificacionCliente1 as element(ns0:consultarPorIdentificacionCliente) external;

xf:ConsultarPorIdClienteReq($consultarPorIdentificacionCliente1)
