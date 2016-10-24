(:: pragma bea:global-element-parameter parameter="$consultarClientesOrdenesResponse1" element="ns1:ConsultarClientesOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarClientesOrdenesResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarClienteOrdenRes/";

declare function xf:ConsultarClienteOrdenRes($consultarClientesOrdenesResponse1 as element(ns1:ConsultarClientesOrdenesResponse))
    as element(ns0:ConsultarClientesOrdenesResponse) {
        <ns0:ConsultarClientesOrdenesResponse>
            {
                for $orden in $consultarClientesOrdenesResponse1/orden
                return
                    <orden>{ $orden/@* , $orden/node() }</orden>
            }
        </ns0:ConsultarClientesOrdenesResponse>
};

declare variable $consultarClientesOrdenesResponse1 as element(ns1:ConsultarClientesOrdenesResponse) external;

xf:ConsultarClienteOrdenRes($consultarClientesOrdenesResponse1)
