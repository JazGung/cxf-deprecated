package net.jazgung.cfx.annotation;

import java.util.Calendar;

import javax.xml.ws.Holder;

import org.junit.BeforeClass;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.dto.RspDto;
import net.jazgung.cfx.annotation.webservice.AnnotationService;
import net.jazgung.cfx.annotation.webservice.AnnotationServiceImpl;
import net.jazgung.cfx.quickstart.server.impl.EndpointImpl;
import net.jazgung.cfx.util.ClientFactory;
import net.jazgung.cfx.webservice.WebServiceUtils;

public class AnnotationServiceTest extends GenericTest {

	private static AnnotationService service;

	@BeforeClass
	public static void beforeClass() throws Exception {
		main();
		try {
			service = (new ClientFactory<AnnotationService>(
					WebServiceUtils.calcWsdlhUrl(AnnotationService.class, AnnotationService.ADDRESS), AnnotationService.SERVICE_NAME))
							.getService(AnnotationService.PORT_NAME, AnnotationService.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String... args) {
		EndpointImpl server = new EndpointImpl();
		server.startup(AnnotationService.class, new AnnotationServiceImpl());
	}

	@Test
	public void test00() {
		printCutOffRule("begin test00");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		System.out.println("echo: " + service.service(req).getEcho());
		printCutOffRule("end test00");
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
	public void test01I() {
		printCutOffRule("begin test01I");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		System.out.println("echo: " + service.service1(req, 0).getEcho());
		printCutOffRule("end test01I");
	}

	@Test
	public void test02() {
		printCutOffRule("begin test02");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		Holder<String> say1 = new Holder<String>("say1");
		Holder<String> say2 = new Holder<String>("say2");
		System.out.println("echo: " + service.service2(req, say1, say2).getEcho() + "," + say1.value + "," + say2.value);
		printCutOffRule("end test02");
	}

	@Test
	public void test03() {
		printCutOffRule("begin test03");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		Holder<RspDto> say = new Holder<RspDto>();
		service.service3(req, say);
		System.out.println("echo: " + say.value.getEcho());
		printCutOffRule("end test03");
	}

	@Test
	public void test04() {
		printCutOffRule("begin test04");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		System.out.println("echo: " + service.service4(req).getEcho());
		printCutOffRule("end test04");
	}

	@Test
	public void test05() {
		printCutOffRule("begin test05");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		Holder<RspDto> say1 = new Holder<RspDto>();
		Holder<RspDto> say2 = new Holder<RspDto>();
		service.service5(req, req, say1, say2);
		System.out.println("echo: " + say1.value.getEcho());
		printCutOffRule("end test05");
	}

	@Test
	public void test50() {
		printCutOffRule("begin test50");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		Holder<String> timeStamp = new Holder<String>(Calendar.getInstance().toString());
		System.out.println("echo: " + service.service50("1.2.3", timeStamp, req).getEcho());
		printCutOffRule("end test50");
	}

	@Test
	public void test51() {
		printCutOffRule("begin test51");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		Holder<String> timeStamp = new Holder<String>(Calendar.getInstance().toString());
		Holder<RspDto> say = new Holder<RspDto>();
		service.service51("1.2.3", timeStamp, req, say);
		System.out.println("echo: " + say.value.getEcho());
		printCutOffRule("end test51");
	}

	@Test
	public void test52() {
		// 测试接收请求异常
		printCutOffRule("begin test52");
		try {
			ReqDto req = new ReqDto();
			req.setWord("Hello World");

			Holder<String> timeStamp = new Holder<String>(Calendar.getInstance().toString());
			Holder<RspDto> say = new Holder<RspDto>();
			service.service52("1.2.3", timeStamp, req, say);
			System.out.println("echo: " + say.value.getEcho());
		} catch (Exception e) {
		}
		printCutOffRule("end test52");
	}

	@Test
	public void test60() {
		printCutOffRule("begin test60");
		ReqDto req = new ReqDto();
		req.setWord("Hello World");

		System.out.println("echo: " + service.service60(req).getEcho());
		printCutOffRule("end test60");
	}

}
