package com.example.demo;

import java.util.HashMap;
import java.util.Map;

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

    public static int maximumSum(int k, int[] numbers) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += numbers[i];
        }

        maxSum = Math.max(maxSum, currentSum);

        int windowStart = 1;

        for (int windowEnd = k; windowEnd < numbers.length; windowEnd++) {
            currentSum -= numbers[windowStart - 1];
            currentSum += numbers[windowEnd];
            maxSum = Math.max(maxSum, currentSum);
            windowStart++;
        }

        return maxSum;
    }

    public static int smallestSubArray(int s, int[] numbers) {
        int windowStart = 0;
        int windowEnd = 0;
        int smallestLength = Integer.MAX_VALUE;
        boolean matchFound = false;
        int currentSum = numbers[0];

        while (windowStart <= numbers.length - 1) {
            int subArraySize = (windowEnd - windowStart) + 1;
            if (currentSum >= s) {
                matchFound = true;
                smallestLength = Math.min(smallestLength, subArraySize);
                if (smallestLength == 1) { break; }
                currentSum -= numbers[windowStart];
                windowStart++;
            } else {
                windowEnd++;
                if (windowEnd > numbers.length - 1) { break; }
                currentSum += numbers[windowEnd];
            }
        }

        return !matchFound ? 0 : smallestLength;
    }

    public static int longestSubstringKDistinct(int k, String input) {
        Map<Character, Integer> distinctChars = new HashMap<Character, Integer>() {};
        int windowStart = 0;
        int windowEnd = 0;
        int longestSubStringSize = Integer.MIN_VALUE;
        boolean matchFound = false;
        distinctChars.put(input.charAt(0), 1);

        while (windowStart <= input.length() - 1) {
            int currentSubStringSize = (windowEnd - windowStart) + 1;
            if (distinctChars.size() <= k) {
                longestSubStringSize = Math.max(longestSubStringSize, currentSubStringSize);
                matchFound = true;

                windowEnd++;
                if (windowEnd > input.length() - 1) { break; }
                char windowEndChar = input.charAt(windowEnd);
                if (distinctChars.containsKey(windowEndChar)) {
                    Integer val = distinctChars.get(windowEndChar);
                    distinctChars.put(windowEndChar, val + 1);
                } else {
                    distinctChars.put(windowEndChar, 1);
                }
            } else {
                char windowStartChar = input.charAt(windowStart);
                Integer val = distinctChars.get(windowStartChar);
                if (val > 1) {
                    distinctChars.put(windowStartChar, val - 1);
                } else {
                    distinctChars.remove(windowStartChar);
                }
                windowStart++;
            }
        }


        return !matchFound ? 0 : longestSubStringSize;
    }

    public static int maxFruitCountOf2Types(char[] fruit) {
        Map<Character, Integer> fruitBaskets = new HashMap<Character, Integer>() {};
        int windowStart = 0;
        int windowEnd = 0;
        int maxFruitCount = Integer.MIN_VALUE;
        boolean matchFound = false;
        fruitBaskets.put(fruit[0], 1);

        while (windowStart <= fruit.length - 1) {
            int currentFruitCount = (windowEnd - windowStart) + 1;
            if (fruitBaskets.size() <= 2) {
                maxFruitCount = Math.max(maxFruitCount, currentFruitCount);
                matchFound = true;
                windowEnd++;

                if (windowEnd > fruit.length - 1) { break; }
                char windowEndChar = fruit[windowEnd];
                if (fruitBaskets.containsKey(windowEndChar)) {
                    Integer val = fruitBaskets.get(windowEndChar);
                    fruitBaskets.put(windowEndChar, val + 1);
                } else {
                    fruitBaskets.put(windowEndChar, 1);
                }
            } else {
                char windowStartChar = fruit[windowStart];
                Integer val = fruitBaskets.get(windowStartChar);
                if (val > 1) {
                    fruitBaskets.put(windowStartChar, val - 1);
                } else {
                    fruitBaskets.remove(windowStartChar);
                }
                windowStart++;
            }
        }

        return !matchFound ? 0 : maxFruitCount;
    }

    public static int noRepeatSubstring(String input) {
        Map<Character, Integer> distinctChars = new HashMap<Character, Integer>() {};
        int windowStart = 0;
        int windowEnd = 0;
        int longestSubStringSize = Integer.MIN_VALUE;
        boolean matchFound = false;
        distinctChars.put(input.charAt(0), 1);

        while (windowStart <= input.length() - 1) {
            int currentSubStringSize = (windowEnd - windowStart) + 1;
            boolean anyDuplicates = distinctChars
                    .values()
                    .stream()
                    .anyMatch(val -> val > 1);
            if (!anyDuplicates) {
                longestSubStringSize = Math.max(longestSubStringSize, currentSubStringSize);
                matchFound = true;

                windowEnd++;
                if (windowEnd > input.length() - 1) { break; }
                char windowEndChar = input.charAt(windowEnd);
                if (distinctChars.containsKey(windowEndChar)) {
                    Integer val = distinctChars.get(windowEndChar);
                    distinctChars.put(windowEndChar, val + 1);
                } else {
                    distinctChars.put(windowEndChar, 1);
                }
            } else {
                char windowStartChar = input.charAt(windowStart);
                Integer val = distinctChars.get(windowStartChar);
                if (val > 1) {
                    distinctChars.put(windowStartChar, val - 1);
                } else {
                    distinctChars.remove(windowStartChar);
                }
                windowStart++;
            }
        }


        return !matchFound ? 0 : longestSubStringSize;
    }
}
