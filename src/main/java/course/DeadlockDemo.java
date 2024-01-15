package course;

import inners.Action;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergei Aleshchenko
 * @project Learning
 */
public class DeadlockDemo {
    public static void main(String[] args) throws InterruptedException {
        Runner2 runner2 = new Runner2();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner2.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner2.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner2.finished();
    }
}

class Runner2 {
    private Account account1 = new Account();
    private Account account2 = new Account();

//    private Lock lock1 = new ReentrantLock();
//    private Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken) {
                    lock1.unlock();
                }

                if (secondLockTaken) {
                    lock2.unlock();
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
//            lock1.lock();
//            lock2.lock();

//            takeLocks(lock1, lock2);

            synchronized (account1) {
                synchronized (account2) {
                    Account.transfer(account1, account2, random.nextInt(100));
                }
            }
//            try {
//                Account.transfer(account1, account2, random.nextInt(100));
//            } finally {
//                lock1.unlock();
//                lock2.unlock();
//            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
//            lock2.lock();
//            lock1.lock();

//            takeLocks(lock2, lock1);
            synchronized (account2) {
                synchronized (account1) {
                    Account.transfer(account2, account2, random.nextInt(100));
                }
            }

//            try {
//                Account.transfer(account2, account1, random.nextInt(100));
//            } finally {
//                lock1.unlock();
//                lock2.unlock();
//            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account account1, Account account2, int amount) {
        account1.withdraw(amount);
        account2.deposit(amount);
    }
}
