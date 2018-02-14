package net.jazgung.cfx.xml_type;

import org.junit.Assert;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.util.ServerUtil;
import net.jazgung.cfx.xml_type.webservice.request.RequestXmlTypeService;
import net.jazgung.cfx.xml_type.webservice.request.RequestXmlTypeServiceImpl;

public class RequestXmlTypeServiceTest extends GenericTest {

	@Test
	public void test() throws InterruptedException {
		try {
			ServerUtil.startup(RequestXmlTypeService.class, new RequestXmlTypeServiceImpl());
			Assert.fail("未抛出异常");
		} catch (Throwable t) {
			t.printStackTrace();
			Throwable t1 = t;
			while (null != t1 && !"1 counts of IllegalAnnotationExceptions".equals(t1.getMessage())) {
				t1 = t1.getCause();
			}

			Assert.assertNotNull("抛出指定的异常", t1);
		}
	}
}
