import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            for (int j = 0; j < M; j++) {
                if (!st.hasMoreTokens()) {
                    line = br.readLine();
                    st = new StringTokenizer(line);
                }
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        int top = 0, bottom = N - 1;
        int left = 0, right = M - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                sb.append(matrix[top][j]).append(" ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                sb.append(matrix[i][right]).append(" ");
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    sb.append(matrix[top][j] != matrix[bottom][j] ? matrix[bottom][j] + " " : matrix[bottom][j] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    sb.append(matrix[i][left]).append(" ");
                }
                left++;
            }
        }

        System.out.println(sb.toString().trim());
    }
}

