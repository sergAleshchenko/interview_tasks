package interview_300_questions.inner_classes;

public class InnerClassExample {

    private int data = 30;

    void display() {
        int value = 50;

        class Local {
            void msg() {
                System.out.println(value);
            }
        }

        Local local = new Local();
        local.msg();
    }

    public static void main(String[] args) {
        InnerClassExample obj = new InnerClassExample();
        obj.display();
    }
}
