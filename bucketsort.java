import java.io.*;
import java.util.*;

public class bucketsort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;

        StringTokenizer st = new StringTokenizer(line);
        if (!st.hasMoreTokens()) return;

        int n = Integer.parseInt(st.nextToken());

        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            double num = Double.parseDouble(st.nextToken());
            int bucketIdx = (int) (num * n);
            if (bucketIdx >= n) {
                bucketIdx = n - 1;
            }
            buckets[bucketIdx].add(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
            for (double val : buckets[i]) {
                sb.append(String.format(Locale.US, "%.2f", val)).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
