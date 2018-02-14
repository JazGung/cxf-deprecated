package net.jazgung.cfx.binding;

import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.BeforeClass;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.binding.dto.ReqDto;
import net.jazgung.cfx.binding.webservice.BindingService;
import net.jazgung.cfx.binding.webservice.HttpServiceImpl;
import net.jazgung.cfx.binding.webservice.PureXmlServiceImpl;
import net.jazgung.cfx.binding.webservice.Soap1_1ServiceImpl;
import net.jazgung.cfx.binding.webservice.Soap1_2ServiceImpl;
import net.jazgung.cfx.quickstart.client.Client;
import net.jazgung.cfx.quickstart.client.impl.JaxWsProxyFactoryBeanImpl;
import net.jazgung.cfx.util.ServerUtil;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class BindingServiceTest extends GenericTest {

	private void invoke(BindingService service) {
		ReqDto req = new ReqDto();
		req.setWord("Hello World");
		System.out.println("echo: " + service.service(req).getEcho());
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		main();
	}

	public static void main(String... args) {
		ServerUtil.startup(BindingService.class, new PureXmlServiceImpl());
		ServerUtil.startup(BindingService.class, new Soap1_1ServiceImpl());
		ServerUtil.startup(BindingService.class, new Soap1_2ServiceImpl());
		ServerUtil.startup(BindingService.class, new HttpServiceImpl());
	}

	@Test
	public void testPureXml() {
		printCutOffRule("begin testPureXml");

		Client client = new JaxWsProxyFactoryBeanImpl() {
			@Override
			public void configFactory() {
				factory.setBindingId("http://cxf.apache.org/bindings/xformat");
			}
		};

		BindingService service = client.getService(WebServiceUtils.calcPublishUrl(BindingService.class, PureXmlServiceImpl.ADDRESS), "", "",
				BindingService.class);

		invoke(service);

		printCutOffRule("end testPureXml");
	}

	@Test
	public void testSoap1_1() {
		printCutOffRule("begin testSoap1_1");

		Client client = new JaxWsProxyFactoryBeanImpl() {
			@Override
			public void configFactory() {
				factory.setBindingId(SOAPBinding.SOAP11HTTP_BINDING);
			}
		};

		BindingService service = client.getService(WebServiceUtils.calcPublishUrl(BindingService.class, Soap1_1ServiceImpl.ADDRESS), "", "",
				BindingService.class);

		invoke(service);

		printCutOffRule("end testSoap1_1");
	}

	@Test
	public void testSoap1_2() {
		printCutOffRule("begin testSoap1_2");

		Client client = new JaxWsProxyFactoryBeanImpl() {
			@Override
			public void configFactory() {
				factory.setBindingId(SOAPBinding.SOAP12HTTP_BINDING);
			}
		};

		BindingService service = client.getService(WebServiceUtils.calcPublishUrl(BindingService.class, Soap1_2ServiceImpl.ADDRESS), "", "",
				BindingService.class);

		invoke(service);

		printCutOffRule("end testSoap1_2");
	}

	@Test
	public void testHttp() {
		printCutOffRule("begin testHttp");

		Client client = new JaxWsProxyFactoryBeanImpl() {
			@Override
			public void configFactory() {
				factory.setBindingId(HTTPBinding.HTTP_BINDING);
			}
		};

		BindingService service = client.getService(WebServiceUtils.calcPublishUrl(BindingService.class, HttpServiceImpl.ADDRESS), "", "",
				BindingService.class);

		invoke(service);

		printCutOffRule("end testHttp");
	}
}
