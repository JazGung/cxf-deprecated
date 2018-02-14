package net.jazgung.cfx.annotation.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.cxf.interceptor.InInterceptors;

import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.dto.RspDto;
import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.webservice.WebServiceConstans;

//在接口中，@WebService.name用于指定wsdl文件中{http://schemas.xmlsoap.org/wsdl/}portType.name的值，默认为接口的类名
@WebService(name = AnnotationService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
public interface AnnotationService {

	final String NAME = "AnnotationService";

	public final String EPI_NAME = "net.jazgung.cfx.annotation.webservice.AnnotationService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public static final String ADDRESS = "AnnotationService";

	RspDto service(ReqDto text);

	// @WebMethod.name用于指定wsdl文件中{http://schemas.xmlsoap.org/wsdl/}portType/{http://schemas.xmlsoap.org/wsdl/}operation.name的值，如不配置默认为方法名
	@WebMethod(operationName = "ServiceXXX")
	RspDto service1(ReqDto text);

	// 可以使用@WebMethod.name完成方法的重载
	@WebMethod(operationName = "ServiceXXX_I")
	RspDto service1(ReqDto text, int i);

	@WebMethod(operationName = "Service2")
	// @RequestWrapper用于将参数中所有@WebParam.mode为WebParam.Mode.IN或WebParam.Mode.INOUT的字段进行封装为一个节点，将会在请求中作为{http://schemas.xmlsoap.org/soap/envelope/}Envelope/{http://schemas.xmlsoap.org/soap/envelope/}Body的直接子节点
	// @RequestWrapper.localName用于定义节点名，如不配置默认为@WebMethod.name
	// @RequestWrapper.targetNamespace用于定义节点名字空间，如不配置默认为@WebService.targetNamespace
	@RequestWrapper(localName = "Service2Req", targetNamespace = WebServiceConstans.NAME_SPACE + "/Req")
	// @ResponseWrapper用于将返回值和参数中所有@WebParam.mode为WebParam.Mode.INOUT或WebParam.Mode.OUT的字段进行封装一个节点，将会在响应中作为{http://schemas.xmlsoap.org/soap/envelope/}Envelope/{http://schemas.xmlsoap.org/soap/envelope/}Body的直接子节点
	// @ResponseWrapper.localName用于定义节点名，如不配置默认为@WebMethod.name+<Response>
	// @ResponseWrapper.targetNamespace用于定义节点名字空间
	@ResponseWrapper(localName = "Service2Res", targetNamespace = WebServiceConstans.NAME_SPACE + "/Res")
	// @WebResult用于指定方法返回对象所有字段的父节点
	// @WebResult.name的值表示节点名，如不配置默认为<return>
	// @WebResult.targetNamespace指定节点名字空间，如不配置则无名字空间
	@WebResult(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE + "/Result")
	RspDto service2(
			// @WebParam.name指定参数字段在请求报文中的节点名，如不配置默认为<agr>+[从0开始依次递增的序号]
			// @WebParam.targetNamespace指定参数字段在请求报文中的节点名，如不配置则无名字空间
			@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE + "/Param") ReqDto text//
			// @WebParam.mode指定参数对应字段是否在请求或响应报文中出现
			// @WebParam.mode = WebParam.Mode.IN表示该字段只在请求参报文出现
			// @WebParam.mode = WebParam.Mode.OUT表示该字段只在响应报文中出现
			// @WebParam.mode = WebParam.Mode.INOUT表示该字段同时在请求和响应报文中出现
			// 如果@WebParam.mode为WebParam.Mode.INOUT或WebParam.Mode.OUT，参数类型必须为javax.xml.ws.Holder
			// @WebParam.mode如不配置，默认为WebParam.Mode.IN
			,
			@WebParam(name = "Say1", targetNamespace = WebServiceConstans.NAME_SPACE
					+ "/Param", mode = WebParam.Mode.INOUT) Holder<String> say1//
			, @WebParam(name = "Say2", targetNamespace = WebServiceConstans.NAME_SPACE
					+ "/Param", mode = WebParam.Mode.OUT) Holder<String> say2//
	);

	@RequestWrapper(localName = "Service3Req")
	@ResponseWrapper(localName = "Service3Res")
	// 如果方法没有返回类型，@WebResult将失效
	@WebMethod(operationName = "Service3")
	void service3(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text//
			, @WebParam(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE) Holder<RspDto> say);

	@WebMethod(operationName = "Service4")
	// @SOAPBinding.parameterStyle用于指定参数的封装方式
	// 如果指定为SOAPBinding.ParameterStyle.BARE，请求和响应的各个字段将会作为Body的直接子节点，此时，@RequestWrapper和@ResponseWrapper将失效
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@WebResult(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE)
	RspDto service4(@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text);

	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@WebMethod(operationName = "Service5")
	void service5(@WebParam(name = "Text1", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text1//
			, @WebParam(name = "Text2", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text2//
			, @WebParam(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE, mode = WebParam.Mode.OUT) Holder<RspDto> say//
			, @WebParam(name = "Saying2", targetNamespace = WebServiceConstans.NAME_SPACE, mode = WebParam.Mode.OUT) Holder<RspDto> say2//
	);

	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@WebMethod(operationName = "Service50")
	@WebResult(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE)
	RspDto service50(@WebParam(name = "Version", targetNamespace = WebServiceConstans.NAME_SPACE, header = true) String version, //
			@WebParam(name = "TimeStamp", targetNamespace = WebServiceConstans.NAME_SPACE, header = true) Holder<String> timeStamp, //
			@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text//
	);

	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@WebMethod(operationName = "Service51")
	void service51(@WebParam(name = "Version", targetNamespace = WebServiceConstans.NAME_SPACE, header = true) String version, //
			@WebParam(name = "TimeStamp", targetNamespace = WebServiceConstans.NAME_SPACE, header = true, mode = WebParam.Mode.INOUT) Holder<String> timeStamp, //
			@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text, //
			@WebParam(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE, mode = WebParam.Mode.OUT) Holder<RspDto> say//
	);

	// 在有字段标记为header后，body的字段不能有mode = WebParam.Mode.INOUT，原因未知
	@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
	@WebMethod(operationName = "Service52")
	void service52(@WebParam(name = "Version", targetNamespace = WebServiceConstans.NAME_SPACE, header = true) String version, //
			@WebParam(name = "TimeStamp", targetNamespace = WebServiceConstans.NAME_SPACE, header = true, mode = WebParam.Mode.INOUT) Holder<String> timeStamp, //
			@WebParam(name = "Text", targetNamespace = WebServiceConstans.NAME_SPACE) ReqDto text, //
			@WebParam(name = "Saying", targetNamespace = WebServiceConstans.NAME_SPACE, mode = WebParam.Mode.INOUT) Holder<RspDto> say//
	);

	@RequestWrapper(localName = "Service60Req", targetNamespace = WebServiceConstans.NAME_SPACE)
	@ResponseWrapper(localName = "Service60Res", targetNamespace = WebServiceConstans.NAME_SPACE)
	@WebMethod(operationName = "Service60")
	@WebResult(name = "Saying", targetNamespace = WebServiceConstans.EMPTY_NAME_SPACE)
	RspDto service60(@WebParam(name = "Text", targetNamespace = WebServiceConstans.EMPTY_NAME_SPACE) ReqDto text);
}
