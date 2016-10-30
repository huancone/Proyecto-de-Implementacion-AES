(:: pragma bea:global-element-parameter parameter="$consultarPorIdentificacionClienteResponse1" element="ns1:ConsultarPorIdentificacionClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarPorIdentificacionClienteResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarPorIdClienteRes/";

declare function xf:ConsultarPorIdClienteRes($consultarPorIdentificacionClienteResponse1 as element(ns1:ConsultarPorIdentificacionClienteResponse))
    as element(ns0:consultarPorIdentificacionClienteResponse) {
        <ns0:consultarPorIdentificacionClienteResponse>
            {
                for $cliente in $consultarPorIdentificacionClienteResponse1/cliente
                return
                    <cliente>{ $cliente/@* , $cliente/node() }</cliente>
            }
        </ns0:consultarPorIdentificacionClienteResponse>
};

declare variable $consultarPorIdentificacionClienteResponse1 as element(ns1:ConsultarPorIdentificacionClienteResponse) external;

xf:ConsultarPorIdClienteRes($consultarPorIdentificacionClienteResponse1)
