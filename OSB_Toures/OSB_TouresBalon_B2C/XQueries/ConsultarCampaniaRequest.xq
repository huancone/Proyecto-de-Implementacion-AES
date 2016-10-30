xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$consultarCampaniaProducto1" element="ns0:ConsultarCampaniaProducto" location="../WSDLS/ServiceProxyB2C.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarCampaniaProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarCampaniaRequest/";
declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";

declare function xf:ConsultarCampaniaRequest($consultarCampaniaProducto1 as element(ns0:ConsultarCampaniaProducto))
    as element(ns1:ConsultarCampaniaProducto) {
        <ns1:ConsultarCampaniaProducto/>
};

declare variable $consultarCampaniaProducto1 as element(ns0:ConsultarCampaniaProducto) external;

xf:ConsultarCampaniaRequest($consultarCampaniaProducto1)
