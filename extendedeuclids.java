import java.util.Scanner;

public class Solution {
    static long extGCD(long a, long b, long[] result) {
        if (b == 0) {
            result[0] = 1;
            result[1] = 0;
            return a;
        }
        long[] nextResult = new long[2];
        long g = extGCD(b, a % b, nextResult);
        long x1 = nextResult[0];
        long y1 = nextResult[1];
        result[0] = y1;
        result[1] = x1 - (a / b) * y1;
        return g;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long A = sc.nextLong();
        long B = sc.nextLong();

        long[] res = new long[2];
        long D = extGCD(A, B, res);

        long x0 = res[0];
        long y0 = res[1];

        long stepX = B / D;
        long stepY = A / D;

        long k = Math.round((double) (y0 - x0) / (stepX + stepY));

        long bestX = x0 + k * stepX;
        long bestY = y0 - k * stepY;
        long minSum = Math.abs(bestX) + Math.abs(bestY);

        for (long i = k - 2; i <= k + 2; i++) {
            long cx = x0 + i * stepX;
            long cy = y0 - i * stepY;
            long sum = Math.abs(cx) + Math.abs(cy);

            if (sum < minSum) {
                minSum = sum;
                bestX = cx;
                bestY = cy;
            } else if (sum == minSum) {
                if (cx < bestX || (cx == bestX && cy < bestY)) {
                    bestX = cx;
                    bestY = cy;
                }
            }
        }

        System.out.println(bestX + " " + bestY + " " + D);
    }
}
