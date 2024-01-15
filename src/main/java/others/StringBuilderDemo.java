package others;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        System.out.println(builder.length());
        System.out.println(builder.capacity());

        builder.append("hello");
        System.out.println(builder.length());
        System.out.println(builder.capacity());

        builder.append("oooooooooooo");
        System.out.println(builder.length());
        System.out.println(builder.capacity());

        System.out.println(builder);
        System.out.println(builder.delete(2, 7));
        System.out.println(builder.reverse());


    }

}
