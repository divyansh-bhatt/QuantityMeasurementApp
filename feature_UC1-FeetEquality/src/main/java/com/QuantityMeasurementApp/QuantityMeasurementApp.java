package com.QuantityMeasurementApp;

import java.util.Scanner;
import java.util.Objects;

public class QuantityMeasurementApp {

    /**
     * Inner class representing Feet measurement.
     * Immutable and encapsulated.
     */
    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            // Reflexive check
            if (this == obj) return true;

            // Null & type check
            if (obj == null || getClass() != obj.getClass()) return false;

            // Safe casting
            Feet other = (Feet) obj;

            // Floating-point comparison
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first value in feet: ");
            double value1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter second value in feet: ");
            double value2 = Double.parseDouble(scanner.nextLine());

            Feet feet1 = new Feet(value1);
            Feet feet2 = new Feet(value2);

            boolean result = feet1.equals(feet2);

            System.out.println("Equal (" + result + ")");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        }

        scanner.close();
    }
}
