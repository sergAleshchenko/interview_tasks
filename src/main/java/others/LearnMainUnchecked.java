package others;

public class LearnMainUnchecked {

    public static void main(String[] args) {
        String[] numbers = {"42", "0", "Y-", "33"};
        int result;
        int value = 0;
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            try {
                result = Integer.parseInt(numbers[i]);
                sum += 100 / result;
            } catch (NumberFormatException e) {
                System.err.println(e);
            } catch (ArithmeticException e) {
                System.err.println(e);
            }
        }


//        try {
//            for (int i = 0; i < numbers.length; i++) {
//                result = Integer.parseInt(numbers[i]);
//                sum += 100 / result;
//            }
//        } catch (NumberFormatException e) {
//            System.err.println(e);
//        } catch (ArithmeticException e) {
//            System.err.println(e);
//        }



        System.out.println(sum);
    }
}
