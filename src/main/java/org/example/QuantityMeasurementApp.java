package java.org.example;

import java.util.Objects;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        QuantityWeight w1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight w2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println(w1.equals(w2));

        System.out.println(w1.convertTo(WeightUnit.GRAM));

        System.out.println(w1.add(w2));

        System.out.println(
                new QuantityWeight(2.0, WeightUnit.POUND)
                        .convertTo(WeightUnit.KILOGRAM)
        );
    }
}