import java.io.*;
import java.util.*;

public class addtwonumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int a = sc.nextInt();
        int b = sc.nextInt();

        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }

        System.out.println(a);
    }
}
