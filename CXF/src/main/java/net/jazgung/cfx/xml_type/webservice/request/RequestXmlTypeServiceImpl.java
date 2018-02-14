package net.jazgung.cfx.xml_type.webservice.request;

import javax.jws.WebService;

import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = RequestXmlTypeService.SERVICE_NAME, portName = RequestXmlTypeService.PORT_NAME, endpointInterface = RequestXmlTypeService.EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class RequestXmlTypeServiceImpl extends AbstractWebServiceImpl implements RequestXmlTypeService {

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public void test(TestRequest1 request) {
	}

}
