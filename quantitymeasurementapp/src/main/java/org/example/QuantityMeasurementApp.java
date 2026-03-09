package java.org.example;

import java.util.Objects;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        System.out.println(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(3, LengthUnit.FEET)));

        System.out.println(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(36, LengthUnit.INCH)));

        System.out.println(new QuantityLength(1, LengthUnit.CENTIMETER)
                .equals(new QuantityLength(0.393701, LengthUnit.INCH)));
    }
}