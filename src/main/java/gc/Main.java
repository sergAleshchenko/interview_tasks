package gc;


import generics.Customer;

import java.util.ArrayList;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        while (true) {
            Customer c = new Customer("Michael");
            if (customers.size() >= 100) {
                for (int i = 0; i < 10; i++) {
                    customers.remove(0);
                }
            }
        }
    }
}
