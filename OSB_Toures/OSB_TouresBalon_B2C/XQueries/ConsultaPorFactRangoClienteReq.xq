(:: pragma bea:global-element-parameter parameter="$consultarPorFactRangoCliente1" element="ns0:consultarPorFactRangoCliente" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarPorFactRangoCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultaPorFactRangoClienteReq/";

declare function xf:ConsultaPorFactRangoClienteReq($consultarPorFactRangoCliente1 as element(ns0:consultarPorFactRangoCliente))
    as element(ns1:ConsultarPorFactRangoCliente) {
        <ns1:ConsultarPorFactRangoCliente>
            <fecha_inicial>{ data($consultarPorFactRangoCliente1/fecha_inicial) }</fecha_inicial>
            <fecha_fin>{ data($consultarPorFactRangoCliente1/fecha_fin) }</fecha_fin>
        </ns1:ConsultarPorFactRangoCliente>
};

declare variable $consultarPorFactRangoCliente1 as element(ns0:consultarPorFactRangoCliente) external;

xf:ConsultaPorFactRangoClienteReq($consultarPorFactRangoCliente1)
