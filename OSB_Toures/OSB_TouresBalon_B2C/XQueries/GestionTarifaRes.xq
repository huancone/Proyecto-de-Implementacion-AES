(:: pragma bea:global-element-parameter parameter="$gestionTarifaResponse1" element="ns1:GestionTarifaResponse" location="../WSDLS/ProductosTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:gestionTarifaResponse" location="../WSDLS/ServiceProxyOMS.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/GestionTarifaRes/";

declare function xf:GestionTarifaRes($gestionTarifaResponse1 as element(ns1:GestionTarifaResponse))
    as element(ns0:gestionTarifaResponse) {
        <ns0:gestionTarifaResponse>
            <respuesta>{ $gestionTarifaResponse1/respuesta/@* , $gestionTarifaResponse1/respuesta/node() }</respuesta>
        </ns0:gestionTarifaResponse>
};

declare variable $gestionTarifaResponse1 as element(ns1:GestionTarifaResponse) external;

xf:GestionTarifaRes($gestionTarifaResponse1)
