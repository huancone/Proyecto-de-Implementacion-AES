(:: pragma bea:global-element-parameter parameter="$cancelarOrdenes1" element="ns0:CancelarOrdenes" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:CancelarOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/CancelarOrdenesReq/";

declare function xf:CancelarOrdenesReq($cancelarOrdenes1 as element(ns0:CancelarOrdenes))
    as element(ns1:CancelarOrdenes) {
        <ns1:CancelarOrdenes>
            {
                for $id_orden in $cancelarOrdenes1/id_orden
                return
                    <id_orden>{ data($id_orden) }</id_orden>
            }
        </ns1:CancelarOrdenes>
};

declare variable $cancelarOrdenes1 as element(ns0:CancelarOrdenes) external;

xf:CancelarOrdenesReq($cancelarOrdenes1)
