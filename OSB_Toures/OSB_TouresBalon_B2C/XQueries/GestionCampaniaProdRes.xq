(:: pragma bea:global-element-parameter parameter="$gestionCampaniaProductoResponse1" element="ns1:GestionCampaniaProductoResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:gestionCampaniaProductoResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/GestionCampaniaProdRes/";

declare function xf:GestionCampaniaProdRes($gestionCampaniaProductoResponse1 as element(ns1:GestionCampaniaProductoResponse))
    as element(ns0:gestionCampaniaProductoResponse) {
        <ns0:gestionCampaniaProductoResponse>
            <gestioncampaniaResponse>{ $gestionCampaniaProductoResponse1/gestioncampaniaResponse/@* , $gestionCampaniaProductoResponse1/gestioncampaniaResponse/node() }</gestioncampaniaResponse>
        </ns0:gestionCampaniaProductoResponse>
};

declare variable $gestionCampaniaProductoResponse1 as element(ns1:GestionCampaniaProductoResponse) external;

xf:GestionCampaniaProdRes($gestionCampaniaProductoResponse1)
