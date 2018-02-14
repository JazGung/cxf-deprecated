package net.jazgung.cfx.xml_type.webservice;

import javax.jws.WebService;
import javax.xml.ws.Holder;

import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = XmlTypeService.SERVICE_NAME, portName = XmlTypeService.PORT_NAME, endpointInterface = XmlTypeService.EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class XmlTypeServiceImpl extends AbstractWebServiceImpl implements XmlTypeService {

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public TestResponse test(TestRequest request, Holder<String> s1, Holder<String> s2) {
		return new TestResponse();
	}
}
