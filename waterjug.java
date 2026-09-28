import java.util.Scanner;

public class Solution {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;

        while (sc.hasNextLong()) {
            long a = sc.nextLong();
            if (!sc.hasNextLong()) break;
            long b = sc.nextLong();
            if (!sc.hasNextLong()) break;
            long t = sc.nextLong();

            if (t > Math.max(a, b)) {
                System.out.println("NO");
            } else if (t == 0) {
                System.out.println("YES");
            } else if (t % gcd(a, b) == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
