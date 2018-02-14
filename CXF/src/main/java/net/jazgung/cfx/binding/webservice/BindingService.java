package net.jazgung.cfx.binding.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import net.jazgung.cfx.binding.dto.ReqDto;
import net.jazgung.cfx.binding.dto.RspDto;
import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.log.LoggingFormatOutInterceptor;
import net.jazgung.cfx.webservice.WebServiceConstans;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

@WebService(name = BindingService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface BindingService {

	final String NAME = "BindingService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public final String EPI_NAME = "net.jazgung.cfx.binding.webservice.BindingService";

	final String CLASS_NAME = BindingService.class.getCanonicalName();

	@WebMethod(operationName = "Service")
	@WebResult(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE)
	RspDto service(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text);
}
