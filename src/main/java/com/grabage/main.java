package com.grabage;

public class main {

    public static void main(String[] args) {
        double x = 2.5;
        double y = 2.5;
        test(BasicOperations.class, x, y);
    }

    private static <T extends Enum<T> & Operations> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operations op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n",
                    x, op, y, op.apply(x, y));
    }
}
