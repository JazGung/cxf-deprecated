package net.jazgung.cfx.xml_type;

import java.lang.reflect.Field;

import javax.xml.bind.annotation.XmlType;

import org.apache.cxf.common.util.StringUtils;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.quickstart.client.Client;
import net.jazgung.cfx.quickstart.client.impl.JaxWsProxyFactoryBeanImpl;
import net.jazgung.cfx.util.ServerUtil;
import net.jazgung.cfx.webservice.WebServiceUtils;
import net.jazgung.cfx.xml_type.hepler.AsmHelper;
import net.jazgung.cfx.xml_type.webservice.XmlTypeService;
import net.jazgung.cfx.xml_type.webservice.XmlTypeServiceImpl;

public class XmlTypeServiceTest extends GenericTest {

	private static final Class<XmlTypeService> interfaceClass = XmlTypeService.class;

	@Test
	public void test() throws InterruptedException {
		ServerUtil.startup(interfaceClass, new XmlTypeServiceImpl());

		Client client = new JaxWsProxyFactoryBeanImpl();
		client.getService(WebServiceUtils.calcPublishUrl(interfaceClass, new XmlTypeServiceImpl().getAddress()), "", "", interfaceClass);

		System.out.println("分析CXF为接口" + interfaceClass.getName() + "生成的请求响应动态类：");
		// 读取生成的请求动态类
		String asmRequestClassName = interfaceClass.getPackage().getName() + ".jaxws_asm."
				+ StringUtils.capitalize(XmlTypeService.OPERATION_NAME);
		try {
			Class<?> clazz = AsmHelper.getAsmClass(asmRequestClassName, interfaceClass);
			Field[] fields = clazz.getDeclaredFields();
			System.out.println("请求动态类为：" + clazz.getName());
			XmlType xmlType = clazz.getAnnotation(XmlType.class);
			if (null != xmlType) {
				System.out.println("XmlType为：");
				System.out.println("XmlType.name为：" + xmlType.name());
				System.out.println("XmlType.namespace为：" + xmlType.namespace());
			}
			System.out.println("字段有：");
			for (Field field : fields) {
				System.out.println(" " + field.getType().getName() + " " + field.getName());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("查找" + asmRequestClassName + "未找到");
			e.printStackTrace();
		}

		// 读取生成的响应动态类
		String asmResponseClassName = asmRequestClassName + "Response";
		try {
			Class<?> clazz = AsmHelper.getAsmClass(asmResponseClassName, interfaceClass);
			Field[] fields = clazz.getDeclaredFields();
			System.out.println("响应动态类为：" + clazz.getName());
			XmlType xmlType = clazz.getAnnotation(XmlType.class);
			if (null != xmlType) {
				System.out.println("XmlType为：");
				System.out.println("XmlType.name为：" + xmlType.name());
				System.out.println("XmlType.namespace为：" + xmlType.namespace());
			}
			System.out.println("字段有：");
			for (Field field : fields) {
				System.out.println(" " + field.getType().getName() + " " + field.getName());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("查找" + asmResponseClassName + "未找到");
			e.printStackTrace();
		}
	}
}
