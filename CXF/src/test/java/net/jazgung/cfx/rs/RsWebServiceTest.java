package net.jazgung.cfx.rs;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.rs.client.Client;
import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.rs.server.Server;
import net.jazgung.cfx.rs.webservice.RsWebService;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class RsWebServiceTest extends GenericTest {

	private static RsWebService service;

	@BeforeClass
	public static void beforeClass() {
		main();
		service = Client.getService(WebServiceUtils.calcPublishUrl(RsWebService.class, RsWebService.ADDRESS), RsWebService.class);
	}

	public static void main(String... args) {
		Server.startup();
	}

	@Test
	public void test() {
		service.retrieve();
		service.retrieveById(123);
		service.retrievesByName_param("param");
		service.retrievesByName_form("form");
		service.create(new ReqDto());

		Map<String, Object> form = new HashMap<String, Object>();
		form.put("param1", 1);
		form.put("param2", 2);
		form.put("param3", 3);
		service.updateById(321, form);

		service.update(new ReqDto());
		service.deleteById(135);
		service.deleteById_param(531);
	}
}
