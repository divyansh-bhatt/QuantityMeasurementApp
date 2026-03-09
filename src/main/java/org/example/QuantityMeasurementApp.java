package java.org.example;

import java.util.Objects;

public class QuantityMeasurementApp {
    public static void demonstrateAddition(QuantityLength l1,
                                           QuantityLength l2) {

        QuantityLength result = l1.add(l2);

        System.out.println("add(" + l1 + ", " + l2 + ") = " + result);
    }

    public static void main(String[] args) {

        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCHES);

        demonstrateAddition(a, b);
    }
}