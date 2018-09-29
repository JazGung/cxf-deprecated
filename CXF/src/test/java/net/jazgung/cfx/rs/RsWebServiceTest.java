package net.jazgung.cfx.rs;

import javax.ws.rs.ProcessingException;

import org.apache.cxf.interceptor.Fault;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.rs.client.Client;
import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.rs.dto.UrlEncodedDto;
import net.jazgung.cfx.rs.dto.XmlDto;
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
	public void testHttpGet() {
		printCutOffRule(
				"begin get(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		service.get("path", "query", "matrix", "header", "cookie", "form");
		printCutOffRule(
				"end get(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		printCutOffRule();

		printCutOffRule("begin getPathParamButUnconfig(String pathParam)");
		service.getPathParamButUnconfig("path");
		printCutOffRule("end getPathParamButUnconfig(String pathParam)");
		printCutOffRule();

		printCutOffRule("begin getUnconfig(String param)");
		service.getUnconfig("param");
		printCutOffRule("end getUnconfig(String param)");
		printCutOffRule();

		printCutOffRule("begin getUnconfig(String param1, String param2)");
		try {
			service.getUnconfig("param1", "param2");
			Assert.fail();
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
		printCutOffRule("end getUnconfig(String param1, String param2)");
		printCutOffRule();

		printCutOffRule("begin getDtoParam(ReqDto)");
		try {
			service.getDtoParam(new UrlEncodedDto());
			Assert.fail();
		} catch (Fault f) {
			f.printStackTrace();
		}
		printCutOffRule("end getDtoParam(ReqDto)");
		printCutOffRule();
	}

	@Test
	public void testHttpPost() {
		printCutOffRule(
				"begin post(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		service.post("path", "query", "matrix", "header", "cookie", "form");
		printCutOffRule(
				"end post(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		printCutOffRule();

		printCutOffRule("begin postPathParamButUnconfig(String pathParam)");
		service.postPathParamButUnconfig("path");
		printCutOffRule("end postPathParamButUnconfig(String pathParam)");
		printCutOffRule();

		printCutOffRule("begin postUnconfig(String param)");
		service.postUnconfig("param");
		printCutOffRule("end postUnconfig(String param)");
		printCutOffRule();

		printCutOffRule("begin postUnconfig(String param1, String param2)");
		try {
			service.postUnconfig("param1", "param2");
			Assert.fail();
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
		printCutOffRule("end postUnconfig(String param1, String param2)");
		printCutOffRule();

		printCutOffRule("begin postDtoParam(ReqDto)");
		try {
			service.postDtoParam(new ReqDto());
			Assert.fail();
		} catch (Fault f) {
			f.printStackTrace();
		}
		printCutOffRule("end postDtoParam(ReqDto)");
		printCutOffRule();
	}

	@Test
	public void testHttpPut() {
		printCutOffRule(
				"begin put(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		service.put("path", "query", "matrix", "header", "cookie", "form");
		printCutOffRule(
				"end put(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		printCutOffRule();

		printCutOffRule("begin putPathParamButUnconfig(String pathParam)");
		service.putPathParamButUnconfig("path");
		printCutOffRule("end putPathParamButUnconfig(String pathParam)");
		printCutOffRule();

		printCutOffRule("begin putUnconfig(String param)");
		service.putUnconfig("param");
		printCutOffRule("end putUnconfig(String param)");
		printCutOffRule();

		printCutOffRule("begin putUnconfig(String param1, String param2)");
		try {
			service.putUnconfig("param1", "param2");
			Assert.fail();
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
		printCutOffRule("end putUnconfig(String param1, String param2)");
		printCutOffRule();

		printCutOffRule("begin putDtoParam(ReqDto)");
		try {
			service.putDtoParam(new ReqDto());
			Assert.fail();
		} catch (Fault f) {
			f.printStackTrace();
		}
		printCutOffRule("end putDtoParam(ReqDto)");
		printCutOffRule();
	}

	@Test
	public void testHttpDelete() {
		printCutOffRule(
				"begin delete(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		service.delete("path", "query", "matrix", "header", "cookie", "form");
		printCutOffRule(
				"end delete(String pathParam, String queryParam, String matrixParam, String headerParam, String cookieParam, String formPara)");
		printCutOffRule();

		printCutOffRule("begin deletePathParamButUnconfig(String pathParam)");
		service.deletePathParamButUnconfig("path");
		printCutOffRule("end deletePathParamButUnconfig(String pathParam)");
		printCutOffRule();

		printCutOffRule("begin deleteUnconfig(String param)");
		service.deleteUnconfig("param");
		printCutOffRule("end deleteUnconfig(String param)");
		printCutOffRule();

		printCutOffRule("begin deleteUnconfig(String param1, String param2)");
		try {
			service.deleteUnconfig("param1", "param2");
			Assert.fail();
		} catch (ProcessingException e) {
			e.printStackTrace();
		}
		printCutOffRule("end deleteUnconfig(String param1, String param2)");
		printCutOffRule();

		printCutOffRule("begin deleteDtoParam(ReqDto)");
		try {
			service.deleteDtoParam(new ReqDto());
			Assert.fail();
		} catch (Fault f) {
			f.printStackTrace();
		}
		printCutOffRule("end deleteDtoParam(ReqDto)");
		printCutOffRule();
	}

	@Test
	public void testConsumesAndProduces() {
		service.consumesAndProduces(new XmlDto("Jaz", 18));
	}

	@Test
	public void testMediaTypeUrlEncoded() {
		printCutOffRule("begin urlEncoded(String name, int age)");
		service.urlEncoded("Jaz", 18);
		printCutOffRule("end urlEncoded(String name, int age)");
		printCutOffRule();

		printCutOffRule("begin urlEncoded(ReqDto req)");
		service.urlEncoded(new UrlEncodedDto());
		printCutOffRule("end urlEncoded(ReqDto req)");
		printCutOffRule();

		printCutOffRule("begin urlEncoded()");
		service.urlEncoded();
		printCutOffRule("end urlEncoded()");
		printCutOffRule();
	}

	@Test
	public void testMediaTypeJson() {
		service.json(new ReqDto());
	}
}
