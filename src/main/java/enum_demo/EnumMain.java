package enum_demo;

/**
 * @author Sergei Aleshchenko
 */
public class EnumMain {

    public static void main(String[] args) {
        System.out.println(CdekDeliveryStatuses.getEnumByName(CdekDeliveryStatuses.TAKEN_BY_COURIER.toString()));
    }

}
