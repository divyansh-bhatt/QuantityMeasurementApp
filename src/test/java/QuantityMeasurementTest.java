import java.org.example.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testConvertToBaseUnit_InchesToFeet() {

        double result =
                LengthUnit.INCHES.convertToBaseUnit(12);

        assertEquals(1.0, result, EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_FeetToInches() {

        double result =
                LengthUnit.INCHES.convertFromBaseUnit(1);

        assertEquals(12.0, result, EPSILON);
    }

    @Test
    void testQuantityLengthEquality() {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        assertEquals(a, b);
    }

    @Test
    void testAdditionWithTargetUnit() {

        QuantityLength result =
                new QuantityLength(1, LengthUnit.FEET)
                        .add(new QuantityLength(12, LengthUnit.INCHES),
                                LengthUnit.FEET);

        assertEquals(new QuantityLength(2, LengthUnit.FEET), result);
    }
}