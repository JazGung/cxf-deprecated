package net.jazgung.cfx.quickstart;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.quickstart.client.Client;
import net.jazgung.cfx.quickstart.client.impl.ServiceImpl;
import net.jazgung.cfx.quickstart.dto.ReqDto;
import net.jazgung.cfx.quickstart.webservice.QuickStartService;
import net.jazgung.cfx.quickstart.webservice.QuickStartServiceImpl;
import net.jazgung.cfx.util.ServerUtil;
import net.jazgung.cfx.webservice.WebServiceUtils;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClientTest extends GenericTest {

	private void invoke(Client client) {

		QuickStartService service = client.getService(WebServiceUtils.calcWsdlhUrl(QuickStartService.class, QuickStartService.ADDRESS),
				QuickStartService.SERVICE_NAME, QuickStartService.PORT_NAME, QuickStartService.class);

		ReqDto req = new ReqDto();
		req.setWord("Hello World");
		System.out.println("echo: " + service.service(req).getEcho());
	}

	@BeforeClass
	public static void beforeClass() {
		ServerUtil.startup(QuickStartService.class, new QuickStartServiceImpl());
	}

	@Test
	public void testService() {
		printCutOffRule("beging testService");
		invoke(new ServiceImpl());
		printCutOffRule("end testService");
	}
}
