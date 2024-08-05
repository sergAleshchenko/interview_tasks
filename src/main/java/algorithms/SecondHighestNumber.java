package algorithms;

/**
 * @author Sergei Aleshchenko
 */
public class SecondHighestNumber {

    public static void main(String[] args) {
        int[] numbers = {46, 20, 30, 40, 70, 14, 33, 1000};

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : numbers) {

            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest) {
                secondHighest = num;
            }
        }

        System.out.println("The second highest number in the array is: " + secondHighest);
    }
}
