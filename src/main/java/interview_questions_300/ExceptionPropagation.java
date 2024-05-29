package interview_questions_300;

import java.io.IOException;

/**
 * @author Sergei Aleshchenko
 */
public class ExceptionPropagation {

    void k() {
        int i = 50/0;
    }

    void t() {
        try {
            k();
        } catch (ArithmeticException e) {
            System.out.println("arithmetic exception is thrown");
        }
    }

    void m() throws IOException {
        throw new IOException("device error");
    }

    void n() throws IOException {
        m();
    }

    void p() {
        try {
            n();
        } catch (IOException e) {
            System.out.println("exception handled");
        }
    }

    public static void main(String[] args) {
        ExceptionPropagation ex = new ExceptionPropagation();
        ex.p();
        System.out.println("normal flow...");

        ex.t();
    }
}
