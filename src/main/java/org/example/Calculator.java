package org.example;

public class Calculator {
    public static int add(int a, int b) { return a + b; }

    public static int divInt(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by 0!");
        return a / b;
    }

    public static double divReal(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by 0!");
        return ((double)a) / b;
    }
}
