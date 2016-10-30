(:: pragma bea:global-element-parameter parameter="$gestionTarifa1" element="ns0:gestionTarifa" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:GestionTarifa" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/GestionTarifaReq/";

declare function xf:GestionTarifaReq($gestionTarifa1 as element(ns0:gestionTarifa))
    as element(ns1:GestionTarifa) {
        <ns1:GestionTarifa>
            <tipo_operacion>{ data($gestionTarifa1/tipo_operacion) }</tipo_operacion>
            <tipo_tarifa>{ data($gestionTarifa1/tipo_tarifa) }</tipo_tarifa>
            <tarifa>{ $gestionTarifa1/tarifa/@* , $gestionTarifa1/tarifa/node() }</tarifa>
        </ns1:GestionTarifa>
};

declare variable $gestionTarifa1 as element(ns0:gestionTarifa) external;

xf:GestionTarifaReq($gestionTarifa1)
