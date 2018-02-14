package net.jazgung.cfx.quickstart.client.impl;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import net.jazgung.cfx.quickstart.client.Client;

public class JaxWsProxyFactoryBeanImpl implements Client {

	protected JaxWsProxyFactoryBean factory;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getService(String url, String serviceName, String portName, Class<T> serviceClass) {
		this.factory = new JaxWsProxyFactoryBean();

		factory.setServiceClass(serviceClass);
		factory.setAddress(url);

		configFactory();

		T proxy = (T) factory.create();
		org.apache.cxf.endpoint.Client client = ClientProxy.getClient(proxy);
		configTimeout(client);// 配置超时
		configNamespacePrefix(client);// 配置名字空间前缀
		configServiceCert(client);// 配置业务平台可信证书

		return proxy;
	}

	protected void configFactory() {
		// 工厂配置回调方法，可以由子类重写
	}

	protected void configNamespacePrefix(org.apache.cxf.endpoint.Client client) {
		// 配置回调方法，可以由子类重写
	}

	protected void configTimeout(org.apache.cxf.endpoint.Client client) {
		// 配置回调方法，可以由子类重写
	}

	protected void configServiceCert(org.apache.cxf.endpoint.Client client) {
		// 配置回调方法，可以由子类重写
	}
}
