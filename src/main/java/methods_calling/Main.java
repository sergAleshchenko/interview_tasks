package methods_calling;

import generics.Customer;

/**
 * @author Sergei Aleshchenko
 */
public class Main {

    public static void main(String[] args) {
        int localValue = 5;
        calculate(localValue);
        System.out.println(localValue);

        Customer c = new Customer("Sally");
        renameCustomer(c);
        System.out.println("Main customer: " + c.getName());
        System.out.println(c);
    }


    public static void calculate(int localValue) {
        localValue = localValue * 100;
    }

    public static void renameCustomer(Customer customer) {
        customer.setName("Diane");
        System.out.println("renameCustomer customer: " + customer.getName());
        System.out.println(customer);
    }
}
