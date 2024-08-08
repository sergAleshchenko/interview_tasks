package lightspeed.cloning.utils;

import java.lang.reflect.Field;

/**
 * @author kostas.kougios
 * Date: 06/08/13
 */
public class Logger
{
	public void startCloning(Class<?> clz) {
		System.out.println("clone >>>>  " + clz);
	}

	public void cloning(Field field, Class<?> clz) {
		System.out.println("cloned field >>>>  " + field + "  --- of class " + clz);
	}
}
