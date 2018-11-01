package net.jazgung.cfx.rs;

import java.nio.charset.StandardCharsets;

import javax.ws.rs.ProcessingException;

import org.apache.cxf.interceptor.Fault;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.rs.client.Client;
import net.jazgung.cfx.rs.dto.MultivaluedMapDto;
import net.jazgung.cfx.rs.dto.ReqDto;
import net.jazgung.cfx.rs.dto.UrlEncodedDto;
import net.jazgung.cfx.rs.dto.UrlEncodedEmptyDto;
import net.jazgung.cfx.rs.dto.UrlEncodedFormDto;
import net.jazgung.cfx.rs.dto.XmlDto;
import net.jazgung.cfx.rs.server.Server;
import net.jazgung.cfx.rs.webservice.RsWebService;
import net.jazgung.cfx.util.PropertyValuePrinter;
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
		UrlEncodedDto dto1 = new UrlEncodedDto();
		dto1.setCookieParamFiled("filed");
		dto1.setCookieParamGet("get");
		dto1.setCookieParamSet("set");
		dto1.setFormParamFiled("filed");
		dto1.setFormParamGet("get");
		dto1.setFormParamSet("set");
		dto1.setHeaderParamFiled("filed");
		dto1.setHeaderParamGet("get");
		dto1.setHeaderParamSet("set");
		dto1.setMatrixParamFiled("filed");
		dto1.setMatrixParamGet("get");
		dto1.setMatrixParamSet("set");
		dto1.setPathParam("path1");
		dto1.setQueryParamFiled("filed");
		dto1.setQueryParamGet("get");
		dto1.setQueryParamSet("set");
		PropertyValuePrinter.print(dto1);

		UrlEncodedFormDto dto2 = new UrlEncodedFormDto();
		dto2.setFormParamFiled("filed");
		dto2.setFormParamGet("get");
		dto2.setFormParamSet("set");
		PropertyValuePrinter.print(dto2);

		printCutOffRule("begin urlEncoded(String name, int age)");
		service.urlEncoded("Jaz", 18);
		printCutOffRule("end urlEncoded(String name, int age)");
		printCutOffRule();

		printCutOffRule("begin urlEncoded(UrlEncodedDto dto)");
		service.urlEncoded(dto1);
		printCutOffRule("end urlEncoded(UrlEncodedDto dto)");
		printCutOffRule();

		printCutOffRule("begin urlEncoded(UrlEncodedFormDto dto)");
		service.urlEncoded(dto2);
		printCutOffRule("end urlEncoded(UrlEncodedFormDto dto)");
		printCutOffRule();

		printCutOffRule("begin urlEncoded(UrlEncodedDto dto1, UrlEncodedEmptyDto dto2)");
		service.urlEncoded(dto1, new UrlEncodedEmptyDto());
		printCutOffRule("end urlEncoded(UrlEncodedDto dto1, UrlEncodedEmptyDto dto2)");
		printCutOffRule();

		printCutOffRule("begin urlEncoded()");
		service.urlEncoded();
		printCutOffRule("end urlEncoded()");
		printCutOffRule();

		printCutOffRule("begin urlEncodedMultivaluedMap()");
		service.urlEncodedMultivaluedMap(new MultivaluedMapDto());
		printCutOffRule("end urlEncodedMultivaluedMap()");
		printCutOffRule();

		printCutOffRule("begin urlEncodedMultivaluedMapContentType()");
		service.urlEncodedMultivaluedMapContentType(new MultivaluedMapDto(),
				"application/x-www-form-urlencoded; charset=" + StandardCharsets.UTF_8.name());
		printCutOffRule("end urlEncodedMultivaluedMapContentType()");
		printCutOffRule();
	}

	@Test
	public void test() {
		// UrlEncodedFormDto dto2 = new UrlEncodedFormDto();
		// dto2.setFormParamFiled("filed");
		// dto2.setFormParamGet("get");
		// dto2.setFormParamSet("set");
		// PropertyValuePrinter.print(dto2);
		// printCutOffRule("begin urlEncoded(UrlEncodedDto dto1, UrlEncodedEmptyDto
		// dto2)");
		// service.urlEncoded(dto2);
		// printCutOffRule("end urlEncoded(UrlEncodedDto dto1, UrlEncodedEmptyDto
		// dto2)");
		// printCutOffRule();
		printCutOffRule("begin urlEncodedMultivaluedMap()");
		service.urlEncodedMultivaluedMapContentType(new MultivaluedMapDto(),
				"application/x-www-form-urlencoded; charset=" + StandardCharsets.UTF_8.name());
		printCutOffRule("end urlEncodedMultivaluedMap()");
		printCutOffRule();
	}

	@Test
	public void testMediaTypeJson() {
		service.json(new ReqDto());
	}
}
