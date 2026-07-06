import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int[] arr = new int[n];
     for(int i=0;i<arr.length;i++){
        arr[i] = sc.nextInt();
     }
     int maxSum = arr[0];
     int currSum = arr[0];
     for(int i = 1;i<arr.length;i++){
        if(arr[i]>arr[i-1]){
            currSum+=arr[i];
        }else{
            currSum = arr[i];
        }
        maxSum = Math.max(maxSum,currSum);
     }
     System.out.println(maxSum);
    }
}

