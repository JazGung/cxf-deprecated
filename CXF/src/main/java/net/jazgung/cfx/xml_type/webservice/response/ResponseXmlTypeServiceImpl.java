package net.jazgung.cfx.xml_type.webservice.response;

import javax.jws.WebService;

import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = ResponseXmlTypeService.SERVICE_NAME, portName = ResponseXmlTypeService.PORT_NAME, endpointInterface = ResponseXmlTypeService.EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class ResponseXmlTypeServiceImpl extends AbstractWebServiceImpl implements ResponseXmlTypeService {

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public TestResponse2 test() {
		return new TestResponse2();
	}

}
