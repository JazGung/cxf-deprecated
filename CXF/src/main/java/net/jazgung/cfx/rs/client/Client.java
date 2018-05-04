package net.jazgung.cfx.rs.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class Client {

	public static <T> T getService(String url, Class<T> serviceClass) {
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJsonProvider());

		T proxy = JAXRSClientFactory.create(url, serviceClass, providers);

		return proxy;
	}
}
