import java.org.example.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(2.0, LengthUnit.FEET));

        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {

        QuantityLength result =
                new QuantityLength(6.0, LengthUnit.INCHES)
                        .add(new QuantityLength(6.0, LengthUnit.INCHES));

        assertEquals(new QuantityLength(12.0, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        QuantityLength result =
                new QuantityLength(1.0, LengthUnit.FEET)
                        .add(new QuantityLength(12.0, LengthUnit.INCHES));

        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {

        QuantityLength result =
                new QuantityLength(12.0, LengthUnit.INCHES)
                        .add(new QuantityLength(1.0, LengthUnit.FEET));

        assertEquals(new QuantityLength(24.0, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_WithZero() {

        QuantityLength result =
                new QuantityLength(5.0, LengthUnit.FEET)
                        .add(new QuantityLength(0.0, LengthUnit.INCHES));

        assertEquals(new QuantityLength(5.0, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NullSecondOperand() {

        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(1.0, LengthUnit.FEET).add(null));
    }
}