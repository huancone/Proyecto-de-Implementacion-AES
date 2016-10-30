(:: pragma bea:global-element-parameter parameter="$consultarProducto1" element="ns0:consultarProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarProdReq/";

declare function xf:ConsultarProdReq($consultarProducto1 as element(ns0:consultarProducto))
    as element(ns1:ConsultarProducto) {
        <ns1:ConsultarProducto>
            <tipo_consulta>{ data($consultarProducto1/tipo_consulta) }</tipo_consulta>
            <cadena_consulta>{ data($consultarProducto1/cadena_consulta) }</cadena_consulta>
        </ns1:ConsultarProducto>
};

declare variable $consultarProducto1 as element(ns0:consultarProducto) external;

xf:ConsultarProdReq($consultarProducto1)
