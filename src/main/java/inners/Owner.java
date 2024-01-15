package inners;

import java.util.Comparator;

public class Owner {
    private int value = 1;
    static int statValue = 2;

    static class ValueComparator implements Comparator<Owner> {
        @Override
        public int compare(Owner o1, Owner o2) {
            return o1.value - o2.value;
        }
    }


    static class Nested {

    }


    void action() {
        int a = 2;
        class InnerAction {
            int inner = value;
            int innerA = a;
        }
        new InnerAction();
    }

    static void staticAction() {
        int b = 3;
        class StaticInnerAction {
//            int inner = value;
            int innerB = b;
        }
    }
}
