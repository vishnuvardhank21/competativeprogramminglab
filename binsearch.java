import java.io.*;
import java.util.*;

public class binsearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            System.out.println(Integer.MAX_VALUE);
            return;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        for (int i = 31; i >= 0; i--) {
            if ((absDividend >> i) >= absDivisor) {
                quotient += (1L << i);
                absDividend -= (absDivisor << i);
            }
        }

        long result = isNegative ? -quotient : quotient;
        System.out.println(result);
    }
}