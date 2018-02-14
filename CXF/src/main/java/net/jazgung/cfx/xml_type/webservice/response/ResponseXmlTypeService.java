package net.jazgung.cfx.xml_type.webservice.response;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.log.LoggingFormatOutInterceptor;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(name = ResponseXmlTypeService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface ResponseXmlTypeService {

	final String NAME = "ResponseXmlTypeService";

	public static final String ADDRESS = "ResponseXmlTypeService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public final String EPI_NAME = "net.jazgung.cfx.xml_type.webservice.response.ResponseXmlTypeService";

	@WebMethod(operationName = "testOperation2")
	TestResponse2 test();

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "TestResponse2Response", namespace = WebServiceConstans.NAME_SPACE)
	@XmlType(name = "testOperation2Response")
	public class TestResponse2 {
	}

}
