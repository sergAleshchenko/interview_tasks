package course;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class LambdaDemo3 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArr(arr1);
        fillList(list1);

        // map method
        arr1 = Arrays.stream(arr1).map(x -> 2 * x).toArray();
        list1 = list1.stream().map(x -> 2 * x).collect(Collectors.toList());

        arr1 = Arrays.stream(arr1).map(a -> 3).toArray();
        arr1 = Arrays.stream(arr1).map(a -> a + 1).toArray();

        System.out.println("-------------------------------");
        System.out.println(Arrays.toString(arr1));
        System.out.println(list1);

        // filter method
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println("-------------------------------");

        // forEach method
        Arrays.stream(arr2).forEach(a -> {
            System.out.print(a + " ");
        });

        System.out.println();
        list2.stream().forEach(a -> {
            System.out.print(a + " ");
        });


        // reduce
        int[] arr3 =  new int[10];
        List<Integer> list3 = new ArrayList<>();
        fillArr(arr3);
        fillList(list3);

        int sum1 = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt();
        int product = list3.stream().reduce((acc, b) -> acc * b).get();

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + product);

        int[] arr4 = new int[10];
        fillArr(arr4);

        int[] newArr4 = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();

        System.out.println(Arrays.toString(newArr4));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        Set<Integer> newSet = set.stream().map(a -> a * 3).collect(Collectors.toSet());

        System.out.println(set);
        System.out.println(newSet);

    }


    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
