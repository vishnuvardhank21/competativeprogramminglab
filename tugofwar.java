import java.io.*;
import java.util.*;

public class Solution {
    private static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int[] arr = new int[n];
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            totalSum += arr[i];
        }

        int targetCount = n / 2;
        findMinDiff(arr, 0, 0, 0, targetCount, totalSum);

        System.out.println(minDiff);
    }

    private static void findMinDiff(int[] arr, int index, int count, int currentSum, int targetCount, int totalSum) {
        if (count == targetCount) {
            int diff = Math.abs(totalSum - 2 * currentSum);
            if (diff < minDiff) {
                minDiff = diff;
            }
            return;
        }

        if (index >= arr.length || count + (arr.length - index) < targetCount) {
            return;
        }

        findMinDiff(arr, index + 1, count + 1, currentSum + arr[index], targetCount, totalSum);
        findMinDiff(arr, index + 1, count, currentSum, targetCount, totalSum);
    }
}
