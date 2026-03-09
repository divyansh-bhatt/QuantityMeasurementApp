import java.org.example.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    @Test
    void testEquality_YardToYard_SameValue() {
        assertTrue(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(1, LengthUnit.YARD)));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(3, LengthUnit.FEET)));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new QuantityLength(1, LengthUnit.YARD)
                .equals(new QuantityLength(36, LengthUnit.INCH)));
    }

    @Test
    void testEquality_CentimeterToInch_EquivalentValue() {
        assertTrue(new QuantityLength(1, LengthUnit.CENTIMETER)
                .equals(new QuantityLength(0.393701, LengthUnit.INCH)));
    }

    @Test
    void testEquality_CentimeterToFeet_NonEquivalent() {
        assertFalse(new QuantityLength(1, LengthUnit.CENTIMETER)
                .equals(new QuantityLength(1, LengthUnit.FEET)));
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {

        QuantityLength yard = new QuantityLength(1, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(36, LengthUnit.INCH);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_SameReference() {
        QuantityLength q = new QuantityLength(2, LengthUnit.YARD);
        assertTrue(q.equals(q));
    }

    @Test
    void testEquality_NullComparison() {
        QuantityLength q = new QuantityLength(2, LengthUnit.YARD);
        assertFalse(q.equals(null));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new QuantityLength(1, null));
    }
}