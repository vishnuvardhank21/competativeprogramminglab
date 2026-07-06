import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int el = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                el = arr[i];
                count = 1;
            } else if (arr[i] == el) {
                count++;
            } else {
                count--;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == el) {
                cnt++;
            }
        }
        if (cnt > n / 2) {
            System.out.println(el);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}

