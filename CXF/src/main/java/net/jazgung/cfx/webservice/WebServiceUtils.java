package net.jazgung.cfx.webservice;

public class WebServiceUtils {

	public static String calcPublishUrl(Class<?> clazz, String address) {
		return WebServiceConstans.PUBLISH_ADDRESS + address;
	}

	public static String calcWsdlhUrl(Class<?> clazz, String address) {
		return calcPublishUrl(clazz, address) + "?wsdl";
	}
}
