import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        String p = sc.nextLine().trim();

        int i = 0, j = 0;
        int star = -1;
        int match = 0;

        while (i < s.length()) {

            if (j < p.length() &&
                (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            }
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j;
                match = i;
                j++;
            }
            else if (star != -1) {
                j = star + 1;
                match++;
                i = match;
            }
            else {
                System.out.println(0);
                return;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        System.out.println(j == p.length() ? 1 : 0);
    }
}

