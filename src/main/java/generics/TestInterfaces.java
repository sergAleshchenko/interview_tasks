package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class TestInterfaces {
    public static void main(String[] args) {
        List<CustomerInterface> customers = new ArrayList<>();

        customers.add(new Company(1, "William Wolf",
                "17 Yellow Street", "Acme Industries"));

        customers.add(new Person(2, "Frederick Fox", "54 Orange Road", 31));

        customers.stream().forEach(x -> System.out.println(x.getName()));
    }
}
