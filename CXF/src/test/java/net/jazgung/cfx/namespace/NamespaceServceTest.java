package net.jazgung.cfx.namespace;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Holder;

import org.apache.cxf.jaxb.JAXBDataBinding;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.namespace.webservice.NamespaceService;
import net.jazgung.cfx.namespace.webservice.NamespaceServiceImpl;
import net.jazgung.cfx.quickstart.client.Client;
import net.jazgung.cfx.quickstart.client.impl.JaxWsProxyFactoryBeanImpl;
import net.jazgung.cfx.util.ServerUtil;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class NamespaceServceTest extends GenericTest {

	@Test
	public void testService1Jetty() {
		ServerUtil.startup(NamespaceService.class, new NamespaceServiceImpl());

		Client client = new JaxWsProxyFactoryBeanImpl() {
			@Override
			protected void configNamespacePrefix(org.apache.cxf.endpoint.Client client) {// 配置客户端调用服务端时的名字空间前缀
				org.apache.cxf.service.Service s = client.getEndpoint().getService();
				if (s.getDataBinding() instanceof JAXBDataBinding) {
					Map<String, String> namespace = new HashMap<String, String>();
					namespace.put(NamespaceService.NAMESPACE1, NamespaceService.NAMESPACE1);
					namespace.put(NamespaceService.NAMESPACE2, NamespaceService.NAMESPACE2);
					namespace.put(NamespaceService.DEFUALT, "");

					((JAXBDataBinding) s.getDataBinding()).setNamespaceMap(namespace);
				}
			}
		};

		NamespaceService service = client.getService(WebServiceUtils.calcPublishUrl(NamespaceService.class, NamespaceServiceImpl.ADDRESS),
				"", "", NamespaceService.class);

		service.service1(new Holder<String>("namespace1"), new Holder<String>("namespace2"), new Holder<String>("defualt"));
	}

	@Test
	public void testService1Tomcat() {
		Client client = new JaxWsProxyFactoryBeanImpl() {
			@Override
			protected void configNamespacePrefix(org.apache.cxf.endpoint.Client client) {// 配置客户端调用服务端时的名字空间前缀
				org.apache.cxf.service.Service s = client.getEndpoint().getService();
				if (s.getDataBinding() instanceof JAXBDataBinding) {
					Map<String, String> namespace = new HashMap<String, String>();
					namespace.put(NamespaceService.NAMESPACE1, NamespaceService.NAMESPACE1);
					namespace.put(NamespaceService.NAMESPACE2, NamespaceService.NAMESPACE2);
					namespace.put(NamespaceService.DEFUALT, "");

					((JAXBDataBinding) s.getDataBinding()).setNamespaceMap(namespace);
				}
			}
		};

		NamespaceService service = client.getService("http://localhost:8080/services/NamespaceWebService", "", "", NamespaceService.class);

		service.service1(new Holder<String>("namespace1"), new Holder<String>("namespace2"), new Holder<String>("defualt"));
	}
}
