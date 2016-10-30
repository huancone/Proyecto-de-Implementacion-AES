xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$consultarCampaniaProducto1" element="ns0:consultarCampaniaProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:ConsultarCampaniaProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/ConsultarCampaniaProdReq/";
declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";

declare function xf:ConsultarCampaniaProdReq($consultarCampaniaProducto1 as element(ns0:consultarCampaniaProducto))
    as element(ns1:ConsultarCampaniaProducto) {
        <ns1:ConsultarCampaniaProducto/>
};

declare variable $consultarCampaniaProducto1 as element(ns0:consultarCampaniaProducto) external;

xf:ConsultarCampaniaProdReq($consultarCampaniaProducto1)
