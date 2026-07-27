import java.io.*;
import java.util.*;

public class checkkthbit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        int k = sc.nextInt();

        int isSet = (n >> k) & 1;

        System.out.println(isSet);
    }
}