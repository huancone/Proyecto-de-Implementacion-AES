(:: pragma bea:global-element-parameter parameter="$consultarPorFactRangoClienteResponse1" element="ns1:ConsultarPorFactRangoClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarPorFactRangoClienteResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultaPorFactRangoClienteRes/";

declare function xf:ConsultaPorFactRangoClienteRes($consultarPorFactRangoClienteResponse1 as element(ns1:ConsultarPorFactRangoClienteResponse))
    as element(ns0:consultarPorFactRangoClienteResponse) {
        <ns0:consultarPorFactRangoClienteResponse>
            {
                for $cliente in $consultarPorFactRangoClienteResponse1/cliente
                return
                    <cliente>{ $cliente/@* , $cliente/node() }</cliente>
            }
        </ns0:consultarPorFactRangoClienteResponse>
};

declare variable $consultarPorFactRangoClienteResponse1 as element(ns1:ConsultarPorFactRangoClienteResponse) external;

xf:ConsultaPorFactRangoClienteRes($consultarPorFactRangoClienteResponse1)
