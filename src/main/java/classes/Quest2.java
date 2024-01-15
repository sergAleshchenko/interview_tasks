package classes;

public class Quest2 {
    Quest2 (int i){
        System.out.print("Constructor");
    }
    public static void main(String[] args){
        Quest2 quest = new Quest2(); //1
    }
    public Quest2() {
        //2

    }
    static {
        //3
        new Quest2(1);
    }
}
