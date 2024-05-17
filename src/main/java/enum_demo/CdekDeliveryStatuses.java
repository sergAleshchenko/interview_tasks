package enum_demo;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei Aleshchenko
 */
public enum CdekDeliveryStatuses {
    ACCEPTED(1),
    CREATED(2),
    RECEIVED_AT_SHIPMENT_WAREHOUSE(3),
    READY_TO_SHIP_AT_SENDING_OFFICE (4),
    READY_FOR_SHIPMENT_IN_TRANSIT_CITY(5),
    READY_FOR_SHIPMENT_IN_SENDER_CITY(6),
    RETURNED_TO_SENDER_CITY_WAREHOUSE(7),
    TAKEN_BY_TRANSPORTER_FROM_SENDER_CITY(8),
    SENT_TO_TRANSIT_CITY(9),
    ACCEPTED_IN_TRANSIT_CITY(10),
    ACCEPTED_AT_TRANSIT_WAREHOUSE(11),
    RETURNED_TO_TRANSIT_WAREHOUSE(12),
    READY_TO_SHIP_IN_TRANSIT_OFFICE(13),
    TAKEN_BY_TRANSPORTER_FROM_TRANSIT_CITY(14),
    SENT_TO_SENDER_CITY(15),
    SENT_TO_RECIPIENT_CITY(16),
    ACCEPTED_IN_SENDER_CITY(17),
    ACCEPTED_IN_RECIPIENT_CITY(18),
    ACCEPTED_AT_RECIPIENT_CITY_WAREHOUSE(19),
    ACCEPTED_AT_PICK_UP_POINT(20),
    TAKEN_BY_COURIER(21),
    RETURNED_TO_RECIPIENT_CITY_WAREHOUSE(22),
    DELIVERED(23),
    NOT_DELIVERED(24),
    INVALID(25),
    IN_CUSTOMS_INTERNATIONAL (26),
    SHIPPED_TO_DESTINATION (27),
    PASSED_TO_TRANSIT_CARRIER (28),
    IN_CUSTOMS_LOCAL (29),
    CUSTOMS_COMPLETE (30),
    POSTOMAT_POSTED(31),
    POSTOMAT_SEIZED (32),
    POSTOMAT_RECEIVED(33);


    private Integer value;

    CdekDeliveryStatuses(Integer value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public static Integer getEnumByName(String code) {
        List<String> names = getNames(CdekDeliveryStatuses.class);

        for (String name : names) {
            if (name.equals(code)) return CdekDeliveryStatuses.valueOf(name).value;
        }

        return null;
    }

    public static List<String> getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).collect(Collectors.toList());
    }

}
