package net.jazgung.cfx.quickstart;

import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.quickstart.dto.ReqDto;
import net.jazgung.cfx.quickstart.server.Server;
import net.jazgung.cfx.quickstart.server.impl.EndpointImpl;
import net.jazgung.cfx.quickstart.server.impl.JaxWsServerFactoryBeanImpl;
import net.jazgung.cfx.quickstart.webservice.QuickStartService;
import net.jazgung.cfx.quickstart.webservice.QuickStartServiceImpl;
import net.jazgung.cfx.util.ClientFactory;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class ServerTest extends GenericTest {
	private void invoke(Server server) {
		server.startup(QuickStartService.class, new QuickStartServiceImpl());

		QuickStartService service = (new ClientFactory<QuickStartService>(
				WebServiceUtils.calcWsdlhUrl(QuickStartService.class, QuickStartService.ADDRESS), QuickStartService.SERVICE_NAME))
						.getService(QuickStartService.PORT_NAME, QuickStartService.class);
		ReqDto req = new ReqDto();
		req.setWord("Hello World");
		System.out.println("echo: " + service.service(req).getEcho());

		server.shutdown();
	}

	@Test
	public void testEndpoint() {
		printCutOffRule("begin testEndpoint");
		EndpointImpl server = new EndpointImpl();
		invoke(server);
		printCutOffRule("end testEndpoint");
	}

	@Test
	public void testJaxWsServerFactoryBean() {
		printCutOffRule("begin testJaxWsServerFactoryBean");
		JaxWsServerFactoryBeanImpl server = new JaxWsServerFactoryBeanImpl();
		System.out.println("ServerFactoryImpl");
		invoke(server);
		printCutOffRule("end testJaxWsServerFactoryBean");
	}

}
