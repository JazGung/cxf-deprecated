package net.jazgung.cfx.quickstart.server.impl;

import net.jazgung.cfx.quickstart.server.Server;
import net.jazgung.cfx.quickstart.server.BaseServerImpl;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceUtils;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class JaxWsServerFactoryBeanImpl extends BaseServerImpl implements Server {

	@Override
	public void startup(Class<?> serviceClass, AbstractWebServiceImpl implementor) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setServiceClass(serviceClass);
		factory.setAddress(WebServiceUtils.calcWsdlhUrl(serviceClass, implementor.getAddress()));// 设置wsdl文件发布地址
		factory.setPublishedEndpointUrl(WebServiceUtils.calcPublishUrl(serviceClass, implementor.getAddress()));// 设置发送web服务请求的地址
		factory.setServiceBean(implementor);
		factory.create();
	}
}