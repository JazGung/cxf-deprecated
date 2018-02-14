package net.jazgung.cfx.xml_type;

import org.junit.Assert;
import org.junit.Test;

import net.jazgung.cfx.GenericTest;
import net.jazgung.cfx.util.ServerUtil;
import net.jazgung.cfx.xml_type.webservice.response.ResponseXmlTypeService;
import net.jazgung.cfx.xml_type.webservice.response.ResponseXmlTypeServiceImpl;

public class ResponseXmlTypeServiceTest extends GenericTest {

	@Test
	public void test() {
		try {
			ServerUtil.startup(ResponseXmlTypeService.class, new ResponseXmlTypeServiceImpl());
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
