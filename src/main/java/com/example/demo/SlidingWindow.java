package com.example.demo;

public class SlidingWindow {
    public static double average(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum / numbers.length;
    }

    public static double[] findAverages(int k, double[] numbers) {
        double[] results = new double[numbers.length - k + 1];
        double currentWindowSum = 0;
        for (int i = 0; i < k; i++) {
            currentWindowSum += numbers[i];
        }
        results[0] = currentWindowSum / k;

        int windowStart = 1;
        for (int windowEnd = k; windowEnd < numbers.length; windowEnd++) {
            currentWindowSum -= numbers[windowStart - 1];
            currentWindowSum += numbers[windowEnd];
            results[windowStart] = currentWindowSum / k;
            windowStart++;
        }

        return results;
    }
}
