(:: pragma bea:global-element-parameter parameter="$consultarPorProductoCliente1" element="ns0:consultarPorProductoCliente" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarPorProductoCliente" location="../WSDLS/ClientesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarPorProdClienteReq/";

declare function xf:ConsultarPorProdClienteReq($consultarPorProductoCliente1 as element(ns0:consultarPorProductoCliente))
    as element(ns1:ConsultarPorProductoCliente) {
        <ns1:ConsultarPorProductoCliente>
            <id_producto>{ data($consultarPorProductoCliente1/id_producto) }</id_producto>
        </ns1:ConsultarPorProductoCliente>
};

declare variable $consultarPorProductoCliente1 as element(ns0:consultarPorProductoCliente) external;

xf:ConsultarPorProdClienteReq($consultarPorProductoCliente1)
