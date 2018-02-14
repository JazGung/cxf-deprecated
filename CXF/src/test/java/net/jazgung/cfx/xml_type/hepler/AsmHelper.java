package net.jazgung.cfx.xml_type.hepler;

import java.lang.ref.WeakReference;

import org.apache.cxf.common.util.ASMHelper;

public class AsmHelper extends ASMHelper {

	private static synchronized TypeHelperClassLoader getTypeHelperClassLoader(Class<?> l) {
		WeakReference<TypeHelperClassLoader> ref = LOADER_MAP.get(l);
		TypeHelperClassLoader ret;
		if (ref == null || ref.get() == null) {
			throw new RuntimeException(l.getName() + "没有对应的TypeHelperClassLoader");
		} else {
			ret = ref.get();
		}
		return ret;
	}

	/**
	 * 获取CXF通过ASM生成的动态类
	 * 
	 * @param className
	 *            动态类的类名
	 * @param interfaceClass
	 *            生成动态类对应的接口
	 * @return CXF通过ASM生成的动态类对应的Class对象
	 * @throws ClassNotFoundException
	 */
	public static Class<?> getAsmClass(String className, Class<?> interfaceClass) throws ClassNotFoundException {
		ClassLoader classLoader = getTypeHelperClassLoader(interfaceClass);
		return classLoader.loadClass(className);
	}
}
