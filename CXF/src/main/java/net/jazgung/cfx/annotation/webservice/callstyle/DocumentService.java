package net.jazgung.cfx.annotation.webservice.callstyle;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.dto.RspDto;
import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.webservice.WebServiceConstans;

import org.apache.cxf.interceptor.InInterceptors;

@WebService(name = DocumentService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
public interface DocumentService {

	final String NAME = "DocumentService";

	public final String EPI_NAME = "net.jazgung.cfx.annotation.webservice.callstyle.DocumentService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public static final String ADDRESS = "DocumentService";

	// DOCUMENT/LITERAL
	@WebMethod(operationName = "Service1")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE, style = Style.DOCUMENT, use = Use.LITERAL)
	RspDto service1(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text);

	// DOCUMENT/ENCODED
	@WebMethod(operationName = "Service2")
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE, style = Style.DOCUMENT, use = Use.ENCODED)
	RspDto service2(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text);
}