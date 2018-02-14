package net.jazgung.cfx.quickstart.server;

import net.jazgung.cfx.webservice.AbstractWebServiceImpl;

public interface Server {

	public abstract void startup(Class<?> serviceClass, AbstractWebServiceImpl implementor);

	public abstract void shutdown();

}