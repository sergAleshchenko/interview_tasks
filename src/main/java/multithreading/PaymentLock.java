package multithreading;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PaymentLock {
    private int amount;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();


    public void doPayment() {
        try {
            System.out.println("Start lock payment: ");
            lock.lock();
            while (amount <= 0) {
                condition.await();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        System.out.println("Payment is closed");
    }

    public void init() {
        try {
            lock.lock();
            System.out.print("Init lock amount: ");
            amount = new Scanner(System.in).nextInt();
        } finally {
            condition.signal();
            lock.unlock();
        }
    }
}
