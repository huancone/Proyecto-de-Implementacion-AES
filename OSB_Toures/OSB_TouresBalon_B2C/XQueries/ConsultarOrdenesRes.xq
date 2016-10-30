(:: pragma bea:global-element-parameter parameter="$consultarOrdenesResponse1" element="ns0:ConsultarOrdenesResponse" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarOrdenesResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.example.org/ServiceProxyOMS/";
declare namespace ns0 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarOrdenesRes/";

declare function xf:ConsultarOrdenesRes($consultarOrdenesResponse1 as element(ns0:ConsultarOrdenesResponse))
    as element(ns1:consultarOrdenesResponse) {
        <ns1:consultarOrdenesResponse>
            {
                for $orden in $consultarOrdenesResponse1/orden
                return
                    <orden>{ $orden/@* , $orden/node() }</orden>
            }
        </ns1:consultarOrdenesResponse>
};

declare variable $consultarOrdenesResponse1 as element(ns0:ConsultarOrdenesResponse) external;

xf:ConsultarOrdenesRes($consultarOrdenesResponse1)
