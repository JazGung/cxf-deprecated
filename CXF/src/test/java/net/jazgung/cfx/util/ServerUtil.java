package net.jazgung.cfx.util;

import net.jazgung.cfx.quickstart.server.Server;
import net.jazgung.cfx.quickstart.server.impl.EndpointImpl;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;

public class ServerUtil {

	private static Server server = new EndpointImpl();

	public static void startup(Class<?> serviceClass, AbstractWebServiceImpl implementor) {
		server.startup(serviceClass, implementor);
	}

	public static void shutdown() {
		server.shutdown();
	}

}
