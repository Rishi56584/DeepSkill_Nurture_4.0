package week_1.dsa.financial_forcasting;

public class Main {
    public static double futureValueRecursive(double initial, double rate, int years) {
        if (years == 0) return initial;
        return futureValueRecursive(initial, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double initial = 10000;
        double rate = 0.10;
        int years = 5;

        long startRecursive = System.nanoTime();
        double resultRecursive = futureValueRecursive(initial, rate, years);
        long endRecursive = System.nanoTime();
        System.out.println("Recursive Future Value after " + years + " years: ₹" + resultRecursive);
        System.out.println("Time taken (recursive): " + (endRecursive - startRecursive) + " ns");

    }
}
