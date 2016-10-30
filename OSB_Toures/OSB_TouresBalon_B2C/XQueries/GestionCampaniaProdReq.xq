(:: pragma bea:global-element-parameter parameter="$gestionCampaniaProducto1" element="ns0:gestionCampaniaProducto" location="../WSDLS/ServiceProxyOMS.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:GestionCampaniaProducto" location="../WSDLS/ProductosTouresBalon.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ProductosTouresBalon/";
declare namespace ns0 = "http://www.example.org/ServiceProxyOMS/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/GestionCampaniaProdReq/";

declare function xf:GestionCampaniaProdReq($gestionCampaniaProducto1 as element(ns0:gestionCampaniaProducto))
    as element(ns1:GestionCampaniaProducto) {
        <ns1:GestionCampaniaProducto>
            <tipo_operacion>{ data($gestionCampaniaProducto1/tipo_operacion) }</tipo_operacion>
            {
                for $campania in $gestionCampaniaProducto1/campania
                return
                    <campania>{ $campania/@* , $campania/node() }</campania>
            }
        </ns1:GestionCampaniaProducto>
};

declare variable $gestionCampaniaProducto1 as element(ns0:gestionCampaniaProducto) external;

xf:GestionCampaniaProdReq($gestionCampaniaProducto1)
