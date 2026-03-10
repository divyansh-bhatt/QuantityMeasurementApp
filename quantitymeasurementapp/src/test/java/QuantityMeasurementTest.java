import java.org.example.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    @Test
    void testAdd() {

        Quantity<LengthUnit> result =
                new Quantity<>(1, LengthUnit.FEET)
                        .add(new Quantity<>(12, LengthUnit.INCHES));

        assertEquals(new Quantity<>(2, LengthUnit.FEET), result);
    }

    @Test
    void testSubtract() {

        Quantity<LengthUnit> result =
                new Quantity<>(10, LengthUnit.FEET)
                        .subtract(new Quantity<>(6, LengthUnit.INCHES));

        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), result);
    }

    @Test
    void testDivide() {

        double result =
                new Quantity<>(10, LengthUnit.FEET)
                        .divide(new Quantity<>(2, LengthUnit.FEET));

        assertEquals(5.0, result);
    }

    @Test
    void testCrossCategory() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(10, LengthUnit.FEET)
                        .add(new Quantity<>(5, WeightUnit.KILOGRAM))
        );
    }
}