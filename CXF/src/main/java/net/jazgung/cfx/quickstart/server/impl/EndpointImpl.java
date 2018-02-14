package net.jazgung.cfx.quickstart.server.impl;

import javax.xml.ws.Endpoint;

import net.jazgung.cfx.quickstart.server.Server;
import net.jazgung.cfx.quickstart.server.BaseServerImpl;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class EndpointImpl extends BaseServerImpl implements Server {

	@Override
	public void startup(Class<?> serviceClass, AbstractWebServiceImpl implementor) {
		Endpoint.publish(WebServiceUtils.calcPublishUrl(serviceClass, implementor.getAddress()), implementor);
	}
}