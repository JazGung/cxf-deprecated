package net.jazgung.cfx.annotation.callstyle;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.webservice.callstyle.DocumentService;
import net.jazgung.cfx.annotation.webservice.callstyle.DocumentServiceImpl;
import net.jazgung.cfx.quickstart.server.impl.EndpointImpl;
import net.jazgung.cfx.util.ClientFactory;
import net.jazgung.cfx.webservice.WebServiceUtils;

import org.junit.BeforeClass;
import org.junit.Test;

public class DocumentServiceTest extends GenericTest {

	private static DocumentService service;

	@BeforeClass
	public static void beforeClass() throws Exception {
		main();
		try {
			service = (new ClientFactory<DocumentService>(WebServiceUtils.calcWsdlhUrl(DocumentService.class, DocumentService.ADDRESS),
					DocumentService.SERVICE_NAME)).getService(DocumentService.PORT_NAME, DocumentService.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String... args) {
		try {
			EndpointImpl server = new EndpointImpl();
			server.startup(DocumentService.class, new DocumentServiceImpl());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
