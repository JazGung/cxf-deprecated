package net.jazgung.cfx.quickstart.client.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import net.jazgung.cfx.quickstart.client.Client;
import net.jazgung.cfx.webservice.WebServiceConstans;

public class ServiceImpl implements Client {

	protected Service service;

	@Override
	public <T> T getService(String wsdlUrlStr, String serviceName, String portName, Class<T> clazz) {
		QName qServiceName = new QName(WebServiceConstans.NAME_SPACE, serviceName);
		URL wsdlUrl = null;
		try {
			wsdlUrl = new URL(wsdlUrlStr);
		} catch (MalformedURLException e) {
			System.err.println("Can not initialize the default wsdl from " + wsdlUrlStr);
		}
		this.service = Service.create(wsdlUrl, qServiceName);

		configService();

		QName qPortName = new QName(WebServiceConstans.NAME_SPACE, portName);
		return service.getPort(qPortName, clazz);
	}

	protected void configService() {
		// 服务配置回调方法，可以由子类重写
	}
}
