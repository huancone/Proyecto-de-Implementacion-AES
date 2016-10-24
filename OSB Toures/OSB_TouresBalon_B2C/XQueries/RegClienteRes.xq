(:: pragma bea:global-element-parameter parameter="$registrarClienteResponse1" element="ns1:RegistrarClienteResponse" location="../WSDLS/ClientesTouresBalon.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:RegistrarClienteResponse" location="../WSDLS/ServiceProxyB2C.wsdl" ::)

declare namespace ns1 = "http://www.touresbalon.com/ClientesTouresBalon/";
declare namespace ns0 = "http://www.touresbalon.com/ServiceProxyB2C/";
declare namespace xf = "http://tempuri.org/OSB_TouresBalon_B2C/XQueries/RegClienteRes/";

declare function xf:RegClienteRes($registrarClienteResponse1 as element(ns1:RegistrarClienteResponse))
    as element(ns0:RegistrarClienteResponse) {
        <ns0:RegistrarClienteResponse>
            <registrarClienteResponse>{ $registrarClienteResponse1/registrarClienteResponse/@* , $registrarClienteResponse1/registrarClienteResponse/node() }</registrarClienteResponse>
        </ns0:RegistrarClienteResponse>
};

declare variable $registrarClienteResponse1 as element(ns1:RegistrarClienteResponse) external;

xf:RegClienteRes($registrarClienteResponse1)
