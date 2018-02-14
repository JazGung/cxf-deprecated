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

//RPC模式下，请求中的所有参数都封装在以@WebMethod.operationName命名的标签下，@SOAPBinding.parameterStyle、@RequestWrapper、@ResponseWrapper会失效，@WebResult有效
@WebService(name = RpcService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
public interface RpcService {

	final String NAME = "RpcService";

	public final String EPI_NAME = "net.jazgung.cfx.annotation.webservice.callstyle.RpcService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public static final String ADDRESS = "RpcService";

	// RPC/LITERAL
	@WebMethod(operationName = "Service1")
	@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
	RspDto service1(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text);

	// RPC/ENCODED
	@WebMethod(operationName = "Service2")
	@SOAPBinding(style = Style.RPC, use = Use.ENCODED)
	RspDto service2(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text);
}