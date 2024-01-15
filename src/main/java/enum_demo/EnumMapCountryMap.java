package enum_demo;

import java.util.EnumMap;

public class EnumMapCountryMap {

    public static void main(String[] args) {
        EnumMap<Country, Integer> map = new EnumMap<>(Country.class);
        map.put(Country.POLAND, 8);
        map.put(Country.UKRAINE, 1);
        map.put(Country.BELARUS, 0);

        System.out.println(map);
    }
}
