(:: pragma bea:global-element-parameter parameter="$consultarPorProductoClienteResponse1" element="ns1:ConsultarPorProductoClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:consultarPorProductoClienteResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarPorProdClienteRes/";

declare function xf:ConsultarPorProdClienteRes($consultarPorProductoClienteResponse1 as element(ns1:ConsultarPorProductoClienteResponse))
    as element(ns0:consultarPorProductoClienteResponse) {
        <ns0:consultarPorProductoClienteResponse>
            {
                for $cliente in $consultarPorProductoClienteResponse1/cliente
                return
                    <cliente>{ $cliente/@* , $cliente/node() }</cliente>
            }
        </ns0:consultarPorProductoClienteResponse>
};

declare variable $consultarPorProductoClienteResponse1 as element(ns1:ConsultarPorProductoClienteResponse) external;

xf:ConsultarPorProdClienteRes($consultarPorProductoClienteResponse1)
