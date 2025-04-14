package epam;

/**
 * @author Sergei Aleshchenko
 */
public class SumBigIntegers {

    static String findSum(String str1, String str2) {

        if (str1.isEmpty() && str2.isEmpty()) {
            return "0";
        }

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        StringBuilder stringBuilder = new StringBuilder();

        int str1Length = str1.length();
        int str2Length = str2.length();

        int difference = str2Length - str1Length;
        int carry = 0;


//        "12";
//        "198111";

        for (int i = str1Length - 1; i >= 0; i--) {
            int n1 = Character.getNumericValue(str1.charAt(i));
            int n2 = Character.getNumericValue(str2.charAt(i + difference));
            int sum = n1 + n2 + carry;

//            int sum = ((str1.charAt(i) - '0') +
//                    (str2.charAt(i + difference) - '0') +
//                    carry);
//            stringBuilder.append((char) (sum % 10 + '0'));

            stringBuilder.append((char) sum % 10);
            carry = sum / 10;
        }

        for (int i = str2Length - str1Length - 1; i >= 0; i--) {
            int n1 = Character.getNumericValue(str2.charAt(i));
            int sum = n1 + carry;

//            int sum = ((str2.charAt(i) - '0') + carry);
//            stringBuilder.append((char) (sum % 10 + '0'));

            stringBuilder.append((char) sum % 10 );
            carry = sum / 10;
        }

        if (carry != 0) {
            stringBuilder.append((char) carry );
        }

        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        String str1 = "19";
        String str2 = "198111";
        System.out.println(findSum(str1, str2));
    }
}
