package net.jazgung.cfx.annotation.callstyle;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.webservice.callstyle.RpcService;
import net.jazgung.cfx.annotation.webservice.callstyle.RpcServiceImpl;
import net.jazgung.cfx.quickstart.server.impl.EndpointImpl;
import net.jazgung.cfx.util.ClientFactory;
import net.jazgung.cfx.webservice.WebServiceUtils;

import org.junit.BeforeClass;
import org.junit.Test;

public class RpcServiceTest extends GenericTest {

	private static RpcService service;

	@BeforeClass
	public static void beforeClass() throws Exception {
		main();
		try {
			service = (new ClientFactory<RpcService>(WebServiceUtils.calcWsdlhUrl(RpcService.class, RpcService.ADDRESS),
					RpcService.SERVICE_NAME)).getService(RpcService.PORT_NAME, RpcService.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String... args) {
		EndpointImpl server = new EndpointImpl();
		server.startup(RpcService.class, new RpcServiceImpl());
	}

	@Test
	public void test01() {
		printCutOffRule("begin test01");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		System.out.println("echo: " + service.service1(req).getEcho());
		printCutOffRule("end test01");
	}

	@Test
	public void test02() {
		printCutOffRule("begin test02");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		System.out.println("echo: " + service.service2(req).getEcho());
		printCutOffRule("end test02");
	}
}
