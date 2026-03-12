package java.org.example;
import java.util.function.Function;
public enum TemperatureUnit implements IMeasurable {

    CELSIUS(
            c -> c,
            c -> c,
            () -> false
    ),

    FAHRENHEIT(
            f -> (f - 32) * 5 / 9,
            c -> (c * 9 / 5) + 32,
            () -> false
    );

    private final Function<Double, Double> toCelsius;
    private final Function<Double, Double> fromCelsius;
    private final SupportsArithmetic supportsArithmetic;

    TemperatureUnit(Function<Double, Double> toCelsius,
                    Function<Double, Double> fromCelsius,
                    SupportsArithmetic supportsArithmetic) {

        this.toCelsius = toCelsius;
        this.fromCelsius = fromCelsius;
        this.supportsArithmetic = supportsArithmetic;
    }

    public double getConversionFactor() {
        return 1.0;
    }

    public double convertToBaseUnit(double value) {
        return toCelsius.apply(value);
    }

    public double convertFromBaseUnit(double baseValue) {
        return fromCelsius.apply(baseValue);
    }

    public String getUnitName() {
        return name();
    }

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation + " operation");
    }
}