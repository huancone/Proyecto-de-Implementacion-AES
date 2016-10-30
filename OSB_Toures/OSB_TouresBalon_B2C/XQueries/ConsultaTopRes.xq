xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$consultaTop5Productos1" element="ns0:ConsultaTop5Productos" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultaTop5Productos" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultaTopRes/";
declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";

declare function xf:ConsultaTopRes($consultaTop5Productos1 as element(ns0:ConsultaTop5Productos))
    as element(ns1:ConsultaTop5Productos) {
        <ns1:ConsultaTop5Productos>
        	{
                for $id_producto in $consultaTop5Productos1/id_producto
                return
                    <id_producto>{ data(xs:int($id_producto)) }</id_producto>
            }
        </ns1:ConsultaTop5Productos>
};

declare variable $consultaTop5Productos1 as element(ns0:ConsultaTop5Productos) external;

xf:ConsultaTopRes($consultaTop5Productos1)
