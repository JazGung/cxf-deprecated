package net.jazgung.cfx.rs.client;

import java.io.ByteArrayInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.ws.WebServiceException;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class Client {

	public static <T> T getService(String url, Class<T> serviceClass) {
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJsonProvider());

		T proxy = JAXRSClientFactory.create(url, serviceClass, providers);

		ClientConfiguration client = WebClient.getConfig(proxy);
		configTimeout(client);// 配置超时
		// configServiceCert(client);// 配置业务平台可信证书

		return proxy;
	}

	private static void configTimeout(ClientConfiguration client) {
		HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy policy = ((HTTPConduit) httpConduit).getClient();
		policy.setConnectionTimeout(5 * 1000);// 设置连接超时
		policy.setReceiveTimeout(600 * 1000);// 设置等待响应超时，10min
	}

	@SuppressWarnings("unused")
	private static void configServiceCert(ClientConfiguration client) {
		HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
		try {
			TLSClientParameters tlsParams = new TLSClientParameters();
			// 采用默认的tls协议
			// tlsParams.setSecureSocketProtocol("SSL");
			// 获取默认的 X509算法
			String algorithm = KeyManagerFactory.getDefaultAlgorithm();
			// 创建密钥管理工厂
			TrustManagerFactory trustManagerfactory = TrustManagerFactory.getInstance(algorithm);
			// 构建以证书相应格式的证书仓库
			KeyStore keyStore = KeyStore.getInstance("JKS");
			// 创建空白keystore
			keyStore.load(null);
			// 添加可信证书
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			ByteArrayInputStream certInputStream = new ByteArrayInputStream(new byte[] {});
			Certificate rtnCertificate = certificateFactory.generateCertificate(certInputStream);
			KeyStore.TrustedCertificateEntry tceInst = new KeyStore.TrustedCertificateEntry(rtnCertificate);
			keyStore.setEntry("tsm.cer", tceInst, null);
			trustManagerfactory.init(keyStore);
			tlsParams.setDisableCNCheck(true);
			TrustManager[] trustManager = trustManagerfactory.getTrustManagers();
			tlsParams.setTrustManagers(trustManager);
			tlsParams.setKeyManagers(new KeyManager[0]);
			httpConduit.setTlsClientParameters(tlsParams);
		} catch (Exception e) {
			throw new WebServiceException("set cert error", e);
		}
	}
}
