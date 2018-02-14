package net.jazgung.cfx.namespace.webservice;

import javax.jws.WebService;
import javax.xml.ws.Holder;

import net.jazgung.cfx.webservice.AbstractWebServiceImpl;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(serviceName = NamespaceService.SERVICE_NAME, portName = NamespaceService.PORT_NAME, endpointInterface = NamespaceService.EPI_NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
public class NamespaceServiceImpl extends AbstractWebServiceImpl implements NamespaceService {

	public static final String ADDRESS = "NamespaceService";

	@Override
	public String getAddress() {
		return ADDRESS;
	}

	@Override
	public void service1(Holder<String> namespace1, Holder<String> namespace2, Holder<String> defualt) {

	}

}
