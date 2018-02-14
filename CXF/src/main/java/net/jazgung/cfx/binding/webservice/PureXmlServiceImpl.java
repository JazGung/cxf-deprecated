package net.jazgung.cfx.binding.webservice;

import static net.jazgung.cfx.binding.webservice.BindingService.EPI_NAME;
import static net.jazgung.cfx.binding.webservice.BindingService.PORT_NAME;
import static net.jazgung.cfx.binding.webservice.BindingService.SERVICE_NAME;

import javax.jws.WebService;
import javax.xml.ws.BindingType;

import net.jazgung.cfx.binding.dto.ReqDto;
import net.jazgung.cfx.binding.dto.RspDto;
import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = SERVICE_NAME, portName = PORT_NAME, endpointInterface = EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@BindingType(value = "http://cxf.apache.org/bindings/xformat")
public class PureXmlServiceImpl extends AbstractWebServiceImpl implements BindingService {

	public static final String ADDRESS = "PureXmlService";

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
