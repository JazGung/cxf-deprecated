package net.jazgung.cfx.annotation.webservice;

import javax.jws.WebService;
import javax.xml.ws.Holder;

import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.dto.RspDto;
import net.jazgung.cfx.log.Logger;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

//在实现类中，@WebService.name用于指定wsdl文件中{http://schemas.xmlsoap.org/wsdl/}service.name的值，默认为实现类的类名+Service
//在实现类中，@WebService.portName用于指定wsdl文件中{http://schemas.xmlsoap.org/wsdl/}port.name的值，默认为实现类的类名+Port
@WebService(serviceName = AnnotationService.SERVICE_NAME, portName = AnnotationService.PORT_NAME, endpointInterface = AnnotationService.EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class AnnotationServiceImpl extends AbstractWebServiceImpl implements AnnotationService {

	private RspDto say(ReqDto word) {
		System.out.println("ws invoked success");
		RspDto rsp = new RspDto();
		rsp.setEcho("word is " + word.getWord());
		System.out.println(rsp.getEcho());
		return rsp;
	}

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public RspDto service(ReqDto text) {
		return say(text);
	}

	@Override
	public RspDto service1(ReqDto text) {
		return say(text);
	}

	@Override
	public RspDto service1(ReqDto text, int i) {
		Logger.log("execut service1 I");
		return say(text);
	}

	@Override
	public RspDto service2(ReqDto text, Holder<String> say1, Holder<String> say2) {
		Logger.log("execut service2");
		say1.value = "return say1";
		say2.value = "return say2";
		return say(text);
	}

	@Override
	public void service3(ReqDto text, Holder<RspDto> say) {
		say.value = say(text);

	}

	@Override
	public RspDto service4(ReqDto text) {
		return say(text);
	}

	@Override
	public void service5(ReqDto text1, ReqDto text2, Holder<RspDto> say1, Holder<RspDto> say2) {
		RspDto say = say(text1);
		say1.value = say;
		say2.value = say;
	}

	@Override
	public RspDto service50(String version, Holder<String> timeStamp, ReqDto text) {
		return say(text);
	}

	@Override
	public void service51(String version, Holder<String> timeStamp, ReqDto text, Holder<RspDto> say) {
		say.value = say(text);
	}

	@Override
	public void service52(String version, Holder<String> timeStamp, ReqDto text, Holder<RspDto> say) {
		say.value = say(text);
	}

	@Override
	public RspDto service60(ReqDto text) {
		return say(text);
	}

}
