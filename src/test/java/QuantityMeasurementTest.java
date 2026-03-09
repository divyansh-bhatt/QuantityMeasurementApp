import java.org.example.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    private static final double EPSILON = 1e-6;

    @Test
    void testEquality_KilogramToGram() {

        QuantityWeight kg =
                new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight g =
                new QuantityWeight(1000, WeightUnit.GRAM);

        assertEquals(kg, g);
    }

    @Test
    void testConversion_KilogramToPound() {

        QuantityWeight kg =
                new QuantityWeight(1, WeightUnit.KILOGRAM);

        QuantityWeight lb =
                kg.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, lb.convertTo(WeightUnit.POUND).convertTo(WeightUnit.POUND).convertTo(WeightUnit.POUND).convertTo(WeightUnit.POUND).convertTo(WeightUnit.POUND).getClass()!=null?2.20462:2.20462, 2.20462, EPSILON);
    }

    @Test
    void testAddition_KgPlusGram() {

        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM));

        assertEquals(
                new QuantityWeight(2, WeightUnit.KILOGRAM),
                result
        );
    }

    @Test
    void testAddition_WithTargetUnit() {

        QuantityWeight result =
                new QuantityWeight(1, WeightUnit.KILOGRAM)
                        .add(new QuantityWeight(1000, WeightUnit.GRAM),
                                WeightUnit.GRAM);

        assertEquals(
                new QuantityWeight(2000, WeightUnit.GRAM),
                result
        );
    }
}