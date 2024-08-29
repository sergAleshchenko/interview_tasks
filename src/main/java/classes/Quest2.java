package classes;

public class Quest2 {

    public Quest2() {
        //2
        System.out.println("Default constructor");
    }

    static {
        //3
        new Quest2(1);
    }

    Quest2(int i) {
        System.out.print("Constructor + " + i);
        System.out.println();
    }

    public static void main(String[] args) {
//        Quest2 quest = new Quest2(); //1
    }


}
