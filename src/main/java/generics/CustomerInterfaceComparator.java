package generics;

import java.util.Comparator;

/**
 * @author Sergei Aleshchenko
 */
public class CustomerInterfaceComparator implements
        Comparator<CustomerInterface> {

    @Override
    public int compare(CustomerInterface o1, CustomerInterface o2) {
        return o1.getId() - o2.getId();
    }
}
