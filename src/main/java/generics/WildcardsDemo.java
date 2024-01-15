package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class WildcardsDemo {
    public static void checkSize(List<? extends CustomerInterface> someList) {
        if (someList.size() > 100) {
            System.out.println("This is a big list");
        } else {
            System.out.println("This is a small list");
        }
    }

    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>();

        companies.add(new Company(13, "William Wolf",
                "17 Yellow Street", "Acme Industries"));

        companies.add(new Company(2, "Cathy Crow",
                "161 Red Road", "Acme Industries"));

        companies.add(new Company(9, "Henry Horse",
                "322 Blue Avenue", "Know Good Company"));



        Collections.sort(companies, new CustomerInterfaceComparator());

        companies.stream().forEach(x -> System.out.println(x.getName()));

        checkSize(companies);
    }


}
