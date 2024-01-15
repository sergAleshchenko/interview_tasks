package classes;


class Base{
    protected Base(){
        System.out.println("Base()");
    }
}

public class Quest extends Base {

    public Quest() {
        super();
        System.out.println("Quest()");
    }

    public static void main(String[] args) {

        Base base = new Base();
        Quest ob = new Quest();

    }
}
