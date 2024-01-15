package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class GenericsMain {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Customer customer1 = new Customer(1, "Simon Brown", "10 East Street");
        Customer customer2 = new Customer(2, "Jean White", "16 North Road");
        Customer customer3 = new Customer(3, "Alison Green", "9 South Gardens");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);

//        for (Customer customer : customers) {
//            System.out.println(customer.getName());
//        }
//
//        Iterator<Customer> iterator = customers.iterator();
//        while (iterator.hasNext()) {
//            Customer nextCustomer = iterator.next();
//            System.out.println(nextCustomer.getName());
//        }


        StringWorker<String, Integer> sw = new StringWorker<>("Hello", 5);
        System.out.println(sw);

        StringWorker<String, String> sw2 = new StringWorker<>("Hello", "world");
        System.out.println(sw2);
        System.out.println(sw2.getO1());

        System.out.println(StringWorker.getString(customer1, "Hello"));
        System.out.println(StringWorker.getString(customer2, customer3));
        System.out.println(
                new StringWorker<>(1, 2).getString3(customer1, customer2));

    }
}
