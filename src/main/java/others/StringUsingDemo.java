package others;

import java.util.Arrays;

public class StringUsingDemo {

    public static void main(String[] args) {
        String str1 = "       667 \n       78       ";

        System.out.println(str1.replaceAll("\\s+", ""));

        String xss = "<script> alert() </script>";
        System.out.println(xss.replaceAll("</?script>", ""));


        str1 = "787asdflkalkdf99234___+==kldj:L233<><>";
        String[] strArr = str1.split("\\D+");
        System.out.println(Arrays.toString(strArr));

    }
}
