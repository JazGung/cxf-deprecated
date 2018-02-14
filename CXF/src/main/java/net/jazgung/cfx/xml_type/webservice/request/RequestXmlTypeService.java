package net.jazgung.cfx.xml_type.webservice.request;

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

@WebService(name = RequestXmlTypeService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface RequestXmlTypeService {

	final String NAME = "RequestXmlTypeService";

	public static final String ADDRESS = "RequestXmlTypeService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public final String EPI_NAME = "net.jazgung.cfx.xml_type.webservice.request.RequestXmlTypeService";

	@WebMethod(operationName = "testOperation1")
	void test(TestRequest1 request);

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "TestRequest", namespace = WebServiceConstans.NAME_SPACE)
	@XmlType(name = "testOperation1")
	public class TestRequest1 {
	}
}
