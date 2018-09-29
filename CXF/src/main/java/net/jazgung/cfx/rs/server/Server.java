package net.jazgung.cfx.rs.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import net.jazgung.cfx.rs.webservice.RsWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class Server {
	public static void startup() {
		Class<RsWebServiceImpl> serviceClass = RsWebServiceImpl.class;
		RsWebServiceImpl implementor = new RsWebServiceImpl();

		// 添加ResourceClass
		List<Class<?>> resourceClasses = new ArrayList<Class<?>>();
		resourceClasses.add(RsWebServiceImpl.class);

		// 添加ResourceProvider
		List<ResourceProvider> resourceProviders = new ArrayList<ResourceProvider>();
		resourceProviders.add(new SingletonResourceProvider(implementor));

		// 添加provider
		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		// 发布REST任务
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setAddress(WebServiceUtils.calcPublishUrl(serviceClass, implementor.getAddress()));
		factory.setResourceClasses(resourceClasses);
		factory.setResourceProviders(resourceProviders);
		factory.setProviders(providerList);
		factory.create();
	}

}
