(:: pragma bea:global-element-parameter parameter="$consultarRankingFechaProducto1" element="ns0:consultarRankingFechaProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarRankingFechaProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultaRnkFechaProdReq/";

declare function xf:ConsultaRnkFechaProdReq($consultarRankingFechaProducto1 as element(ns0:consultarRankingFechaProducto))
    as element(ns1:ConsultarRankingFechaProducto) {
        <ns1:ConsultarRankingFechaProducto>
            <fecha_inicial>{ data($consultarRankingFechaProducto1/fecha_inicial) }</fecha_inicial>
            <fecha_fin>{ data($consultarRankingFechaProducto1/fecha_fin) }</fecha_fin>
        </ns1:ConsultarRankingFechaProducto>
};

declare variable $consultarRankingFechaProducto1 as element(ns0:consultarRankingFechaProducto) external;

xf:ConsultaRnkFechaProdReq($consultarRankingFechaProducto1)
