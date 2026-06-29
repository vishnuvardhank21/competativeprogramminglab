import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int[] arr = new int[n];
     for(int i=0;i<n;i++){
        arr[i] = sc.nextInt();
     }
     int max = 0;
     int min = 0;
     for(int i=0;i<arr.length;i++){
      if(arr[max]<arr[i]){
        max = i;
      }
     }
     for(int i=0;i<arr.length;i++){
      if(arr[i]<arr[min]){
        min = i;
      }
     }
     int temp = arr[max];
     arr[max] = arr[min];
     arr[min] = temp;
     for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
     }
    }
}

