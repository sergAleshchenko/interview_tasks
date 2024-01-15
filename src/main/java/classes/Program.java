package classes;

public class Program {
    public static void main(String[] args) {
        Object obj = new Object();
        Class clazz = obj.getClass();
        System.out.println(clazz.getSuperclass() + ", ");
        Class clazzClass = clazz.getClass();
        System.out.println(clazzClass.getSuperclass());
    }
}
