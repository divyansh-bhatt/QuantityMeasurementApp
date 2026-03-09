package java.org.example;

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactorToKg;

    WeightUnit(double factor) {
        this.conversionFactorToKg = factor;
    }

    public double convertToBaseUnit(double value) {
        return value * conversionFactorToKg;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactorToKg;
    }

    public double getConversionFactor() {
        return conversionFactorToKg;
    }
}