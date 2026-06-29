import java.io.*;
import java.util.*;

public class Solution {
     public static int factorial(int num){
      if(num==1 || num==0){
        return 1;
      }
      return num*factorial((num-1));
     }
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int ans = factorial(n);
     System.out.println(ans);
    }
}
