package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();


        Class personClass1 = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("reflection.Person");


        Method[] methods = personClass1.getMethods();
        Field[] fields = personClass2.getDeclaredFields();
        Annotation[] annotations = personClass3.getAnnotations();


        System.out.println("Annotations: ");
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }

        System.out.println("Fields: ");
        for (Field field : fields) {
            System.out.println(field.getName() + ", " + field.getType());
        }

        System.out.println("Methods: ");
        for (Method method : methods) {
            System.out.println(method.getName() + ", " +
                    method.getReturnType() + ", " +
                    Arrays.toString(method.getParameterTypes()));
        }

    }
}
