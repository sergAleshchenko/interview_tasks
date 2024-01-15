package enum_demo;

import java.util.EnumSet;

import static enum_demo.Country.*;

public class EnumSetCountryMain {
    public static void main(String[] args) {

        EnumSet<Country> asiaCountries = EnumSet.of(ARMENIA, INDIA, KAZAKHSTAN);

        String nameCountry = "Belarus";
        Country current = valueOf(nameCountry.toUpperCase());

        if (asiaCountries.contains(current)) {
            System.out.println("Asia action");
        } else {
            System.out.println("Non asia action");
        }

        asiaCountries.forEach(c -> c.grow(1));
        asiaCountries.forEach(c -> System.out.println(c.getPopulation()));
    }
}
