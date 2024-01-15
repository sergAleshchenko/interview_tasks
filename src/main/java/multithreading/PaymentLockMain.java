package multithreading;

import java.util.concurrent.TimeUnit;

public class PaymentLockMain {
    public static void main(String[] args) {
        PaymentLock paymentLock = new PaymentLock();
        new Thread(() -> paymentLock.doPayment()).start();


        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        paymentLock.init();
        System.out.println("The end");
    }
}
