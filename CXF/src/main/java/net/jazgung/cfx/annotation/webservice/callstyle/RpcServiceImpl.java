package net.jazgung.cfx.annotation.webservice.callstyle;

import javax.jws.WebService;

import net.jazgung.cfx.annotation.dto.ReqDto;
import net.jazgung.cfx.annotation.dto.RspDto;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = RpcService.SERVICE_NAME, portName = RpcService.PORT_NAME, endpointInterface = RpcService.EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class RpcServiceImpl extends AbstractWebServiceImpl implements RpcService {

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
	public RspDto service1(ReqDto text) {
		return say(text);
	}

	@Override
	public RspDto service2(ReqDto text) {
		return say(text);
	}

}
