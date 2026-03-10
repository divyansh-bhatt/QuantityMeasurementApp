import java.org.example.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    @Test
    void testSubtraction_FeetMinusFeet() {

        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .subtract(new Quantity<>(5, LengthUnit.FEET));

        assertEquals(new Quantity<>(5, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_FeetMinusInches() {

        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .subtract(new Quantity<>(6, LengthUnit.INCHES));

        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
    }

    @Test
    void testSubtraction_LitreMinusMillilitre() {

        Quantity<VolumeUnit> result =
                new Quantity<>(5, VolumeUnit.LITRE)
                        .subtract(new Quantity<>(500, VolumeUnit.MILLILITRE));

        assertEquals(new Quantity<>(4.5, VolumeUnit.LITRE), result);
    }

    @Test
    void testDivision_Feet() {

        double result =
                new Quantity<>(10, LengthUnit.FEET)
                        .divide(new Quantity<>(2, LengthUnit.FEET));

        assertEquals(5.0, result);
    }

    @Test
    void testDivision_InchesFeet() {

        double result =
                new Quantity<>(12, LengthUnit.INCHES)
                        .divide(new Quantity<>(1, LengthUnit.FEET));

        assertEquals(1.0, result);
    }

    @Test
    void testDivision_Weight() {

        double result =
                new Quantity<>(10, WeightUnit.KILOGRAM)
                        .divide(new Quantity<>(5, WeightUnit.KILOGRAM));

        assertEquals(2.0, result);
    }

    @Test
    void testDivision_ByZero() {

        assertThrows(
                ArithmeticException.class,
                () -> new Quantity<>(10, LengthUnit.FEET)
                        .divide(new Quantity<>(0, LengthUnit.FEET))
        );
    }
}