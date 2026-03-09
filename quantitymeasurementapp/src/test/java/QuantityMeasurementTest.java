import java.org.example.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    private static final double EPSILON = 1e-6;

    // ---------- LENGTH TESTS ----------

    @Test
    void testLengthEquality_FeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> inches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        assertEquals(feet, inches);
    }

    @Test
    void testLengthConversion_FeetToInches() {

        Quantity<LengthUnit> feet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> result =
                feet.convertTo(LengthUnit.INCHES);

        assertEquals(
                new Quantity<>(12.0, LengthUnit.INCHES),
                result
        );
    }

    @Test
    void testLengthAddition_CrossUnit() {

        Quantity<LengthUnit> result =
                new Quantity<>(1.0, LengthUnit.FEET)
                        .add(new Quantity<>(12.0, LengthUnit.INCHES),
                                LengthUnit.FEET);

        assertEquals(
                new Quantity<>(2.0, LengthUnit.FEET),
                result
        );
    }

    // ---------- WEIGHT TESTS ----------

    @Test
    void testWeightEquality_KgToGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> gram =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        assertEquals(kg, gram);
    }

    @Test
    void testWeightConversion_KgToGram() {

        Quantity<WeightUnit> kg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> result =
                kg.convertTo(WeightUnit.GRAM);

        assertEquals(
                new Quantity<>(1000.0, WeightUnit.GRAM),
                result
        );
    }

    @Test
    void testWeightAddition_CrossUnit() {

        Quantity<WeightUnit> result =
                new Quantity<>(1.0, WeightUnit.KILOGRAM)
                        .add(new Quantity<>(1000.0, WeightUnit.GRAM),
                                WeightUnit.KILOGRAM);

        assertEquals(
                new Quantity<>(2.0, WeightUnit.KILOGRAM),
                result
        );
    }

    // ---------- CROSS CATEGORY CHECK ----------

    @Test
    void testCrossCategoryComparison_ShouldReturnFalse() {

        Quantity<LengthUnit> length =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<WeightUnit> weight =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        assertNotEquals(length, weight);
    }

    // ---------- VALIDATION TESTS ----------

    @Test
    void testConstructor_NullUnit_ShouldThrowException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null)
        );
    }

    @Test
    void testConstructor_InvalidValue_ShouldThrowException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnit.FEET)
        );
    }

    // ---------- ROUND TRIP TEST ----------

    @Test
    void testConversion_RoundTrip() {

        Quantity<WeightUnit> original =
                new Quantity<>(1.5, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> converted =
                original.convertTo(WeightUnit.GRAM)
                        .convertTo(WeightUnit.KILOGRAM);

        assertEquals(original, converted);
    }
}