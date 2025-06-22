package interview_300_questions;

public class IntegerEquivalence {

    public static void main(String[] args) {
        Integer int1 = 201;
        Integer int2 = 201;

        System.out.println(int1 == int2);
        System.out.println(int1.equals(int2));

        Integer int3 = 128;
        Integer int4 = 128;


        System.out.println(int3 == int4);
        System.out.println(int4.equals(int4));

    }
}
