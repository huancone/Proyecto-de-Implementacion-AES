(:: pragma bea:global-element-parameter parameter="$consultarRankingEspectaculosVendidosProducto1" element="ns0:consultarRankingEspectaculosVendidosProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarRankingEspectaculosVendidosProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarRnkEspecVenProdReq/";

declare function xf:ConsultarRnkEspecVenProdReq($consultarRankingEspectaculosVendidosProducto1 as element(ns0:consultarRankingEspectaculosVendidosProducto))
    as element(ns1:ConsultarRankingEspectaculosVendidosProducto) {
        <ns1:ConsultarRankingEspectaculosVendidosProducto>
            <fecha_inicial>{ data($consultarRankingEspectaculosVendidosProducto1/fecha_inicial) }</fecha_inicial>
            <fecha_fin>{ data($consultarRankingEspectaculosVendidosProducto1/fecha_fin) }</fecha_fin>
        </ns1:ConsultarRankingEspectaculosVendidosProducto>
};

declare variable $consultarRankingEspectaculosVendidosProducto1 as element(ns0:consultarRankingEspectaculosVendidosProducto) external;

xf:ConsultarRnkEspecVenProdReq($consultarRankingEspectaculosVendidosProducto1)
