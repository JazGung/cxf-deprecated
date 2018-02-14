package net.jazgung.cfx.quickstart.client;

public interface Client {

	public <T> T getService(String wsdlUrlStr, String serviceName, String portName, Class<T> clazz);

}
