package net.jazgung.cfx.namespace.webservice;

import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

import net.jazgung.cfx.log.LoggingFormatInInterceptor;
import net.jazgung.cfx.log.LoggingFormatOutInterceptor;
import net.jazgung.cfx.webservice.WebServiceConstans;

@WebService(name = NamespaceService.NAME, targetNamespace = WebServiceConstans.NAME_SPACE)
@InInterceptors(interceptors = { LoggingFormatInInterceptor.NAME })
@OutInterceptors(interceptors = { LoggingFormatOutInterceptor.NAME })
public interface NamespaceService {

	final String NAME = "NamespaceService";

	public static final String ADDRESS = "NamespaceService";

	public static final String SERVICE_NAME = NAME + WebServiceConstans.SERVICE_NAME_SURFIX;

	public static final String PORT_NAME = NAME + WebServiceConstans.PORT_NAME_SUFFIX;

	public final String EPI_NAME = "net.jazgung.cfx.namespace.webservice.NamespaceService";

	public static final String NAMESPACE1 = "Namespace1";

	public static final String NAMESPACE2 = "Namespace2";

	public static final String DEFUALT = "Defualt";

	public void service1(//
			@WebParam(name = "namespace1", mode = Mode.INOUT, targetNamespace = NAMESPACE1) Holder<String> namespace1, //
			@WebParam(name = "namespace2", mode = Mode.INOUT, targetNamespace = NAMESPACE2) Holder<String> namespace2, //
			@WebParam(name = "defualt", mode = Mode.INOUT, targetNamespace = DEFUALT) Holder<String> defualt//
	);

}
