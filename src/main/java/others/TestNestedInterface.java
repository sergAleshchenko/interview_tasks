package others;

interface Showable {
    void show();

    interface Message {
        void msg();
    }
}


public class TestNestedInterface implements Showable, Showable.Message {

    @Override
    public void msg() {
        System.out.println("Hello nested interface");
    }


    @Override
    public void show() {

    }

    public static void main(String[] args) {
        Showable.Message message = new TestNestedInterface();
        message.msg();

    }

}
