(:: pragma bea:global-element-parameter parameter="$crearOrdenes1" element="ns0:CrearOrdenes" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:CrearOrdenes" location="../WSDLS/OrdenesTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/OrdenesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/CrearOrdenesReq/";

declare function xf:CrearOrdenesReq($crearOrdenes1 as element(ns0:CrearOrdenes))
    as element(ns1:CrearOrdenes) {
        <ns1:CrearOrdenes>
            <orden>{ $crearOrdenes1/orden/@* , $crearOrdenes1/orden/node() }</orden>
        </ns1:CrearOrdenes>
};

declare variable $crearOrdenes1 as element(ns0:CrearOrdenes) external;

xf:CrearOrdenesReq($crearOrdenes1)
