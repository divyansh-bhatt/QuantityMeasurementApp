package java.org.example;

import java.util.Objects;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println(t1.equals(t2));

        System.out.println(
                t1.convertTo(TemperatureUnit.FAHRENHEIT));

        try {

            t1.add(new Quantity<>(50.0, TemperatureUnit.CELSIUS));

        } catch (UnsupportedOperationException e) {

            System.out.println(e.getMessage());

        }
    }
}