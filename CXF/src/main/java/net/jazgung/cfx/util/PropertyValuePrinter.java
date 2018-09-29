package net.jazgung.cfx.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class PropertyValuePrinter {

	public static void print(Object o) {
		try {
			BeanInfo dtoInfo = Introspector.getBeanInfo(o.getClass());
			for (PropertyDescriptor propertyDescriptor : dtoInfo.getPropertyDescriptors()) {
				System.out.println(propertyDescriptor.getName() + ": " + propertyDescriptor.getReadMethod().invoke(o, new Object[] {}));
			}
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
