package net.jazgung.cfx.util;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import net.jazgung.cfx.webservice.WebServiceConstans;

public class ClientFactory<T> {
	Service service;

	public ClientFactory(String wsdlUrlStr, String methodName) {
		QName serviceName = new QName(WebServiceConstans.NAME_SPACE, methodName);
		URL wsdlUrl = null;
		try {
			wsdlUrl = new URL(wsdlUrlStr);
		} catch (MalformedURLException e) {
			System.err.println("Can not initialize the default wsdl from " + wsdlUrlStr);
		}
		this.service = Service.create(wsdlUrl, serviceName);
	}

	public T getService(String portNameStr, Class<T> clazz) {
		QName portName = new QName(WebServiceConstans.NAME_SPACE, portNameStr);

		return service.getPort(portName, clazz);
	}
}
