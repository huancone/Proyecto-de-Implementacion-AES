(:: pragma bea:global-element-parameter parameter="$consultarClientesOrdenes1" element="ns0:ConsultarClientesOrdenes" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarClientesOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarClienteOrdenReq/";

declare function xf:ConsultarClienteOrdenReq($consultarClientesOrdenes1 as element(ns0:ConsultarClientesOrdenes))
    as element(ns1:ConsultarClientesOrdenes) {
        <ns1:ConsultarClientesOrdenes>
            <id_cliente>{ data($consultarClientesOrdenes1/id_cliente) }</id_cliente>
        </ns1:ConsultarClientesOrdenes>
};

declare variable $consultarClientesOrdenes1 as element(ns0:ConsultarClientesOrdenes) external;

xf:ConsultarClienteOrdenReq($consultarClientesOrdenes1)
