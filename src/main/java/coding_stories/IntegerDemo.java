package coding_stories;

public class IntegerDemo {

    public static void main(String[] args) {
        Integer a = Integer.parseInt("100");
        Integer hex = Integer.decode("0xA");
        Integer octal = Integer.decode("0377");

        Integer bin = Integer.parseInt("11111", 2);
        Integer quat = Integer.parseInt("3233", 4);

        String hexString = Integer.toString(12, 16);
        String unsignedString = Integer.toUnsignedString(-1);

        System.out.println(hex);
        System.out.println(octal);
        System.out.println(bin);
        System.out.println(quat);

        System.out.println();
        System.out.println(hexString);
        System.out.println(unsignedString);


        System.out.println("----------------------------------");
        String hexStr = Integer.toHexString(a);
        String octStr = Integer.toOctalString(a);
        String binString = Integer.toBinaryString(a);

        System.out.println(hexStr);
        System.out.println(octStr);
        System.out.println(binString);


        int leadingZeros = Integer.numberOfLeadingZeros(a);
        System.out.println("0".repeat(leadingZeros) + Integer.toBinaryString(a));
    }
}
