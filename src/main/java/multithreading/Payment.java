package multithreading;

import java.util.Scanner;

public class Payment {
    private int amount;

    public synchronized void doPayment() {
        try {
            System.out.println("Start payment: ");
            while (amount <= 0) {
                this.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Payment is closed");
    }


    public synchronized void init() {
        System.out.print("Init amount: ");
        amount = new Scanner(System.in).nextInt();
        this.notifyAll();
    }
}
