package java.org.example;

import java.util.Objects;

public class QuantityMeasurementApp {
    public static void main(String[] args) {

        Quantity<VolumeUnit> v1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> v2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        System.out.println(v1.equals(v2));

        System.out.println(v1.convertTo(VolumeUnit.MILLILITRE));

        System.out.println(v1.add(v2));

        Quantity<VolumeUnit> v3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        System.out.println(v3.convertTo(VolumeUnit.LITRE));
    }
}