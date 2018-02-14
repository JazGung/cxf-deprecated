package net.jazgung.cfx.quickstart.webservice;

import static net.jazgung.cfx.quickstart.webservice.QuickStartService.EPI_NAME;
import static net.jazgung.cfx.quickstart.webservice.QuickStartService.PORT_NAME;
import static net.jazgung.cfx.quickstart.webservice.QuickStartService.SERVICE_NAME;

import javax.jws.WebService;

import net.jazgung.cfx.quickstart.dto.ReqDto;
import net.jazgung.cfx.quickstart.dto.RspDto;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = SERVICE_NAME, portName = PORT_NAME, endpointInterface = EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class QuickStartServiceImpl extends AbstractWebServiceImpl implements QuickStartService {

	@Override
	public RspDto service(ReqDto word) {
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

}
