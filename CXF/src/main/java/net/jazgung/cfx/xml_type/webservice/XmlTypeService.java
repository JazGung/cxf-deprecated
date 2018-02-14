package net.jazgung.cfx.xml_type.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.ws.Holder;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.log.LoggingFormatOutInterceptor;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(name = XmlTypeService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface XmlTypeService {

	final String NAME = "XmlTypeService";

	final String OPERATION_NAME = "testOperation3";

	public static final String ADDRESS = "XmlTypeService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public final String EPI_NAME = "net.jazgung.cfx.xml_type.webservice.XmlTypeService";

	@WebMethod(operationName = OPERATION_NAME)
	TestResponse test(@WebParam(name = "request", mode = Mode.IN) TestRequest request, //
			@WebParam(name = "s1", mode = Mode.OUT) Holder<String> s1, //
			@WebParam(name = "s2", mode = Mode.INOUT) Holder<String> s2);

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "TestRequest", namespace = WebServiceConstans.NAME_SPACE)
	public static class TestRequest {

	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "TestResponse", namespace = WebServiceConstans.NAME_SPACE)
	public static class TestResponse {

	}

}
