import java.util.*;

public class Solution {
    private static boolean bfs(long[][] rGraph, int s, int t, int[] parent, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < V; v++) {
                if (!visited[v] && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    q.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }

    private static long fordFulkerson(long[][] graph, int s, int t, int V) {
        int u, v;
        long[][] rGraph = new long[V][V];

        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }

        int[] parent = new int[V];
        long maxFlow = 0;

        while (bfs(rGraph, s, t, parent, V)) {
            long pathFlow = Long.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            }

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int V = sc.nextInt();
        int E = sc.nextInt();

        long[][] graph = new long[V][V];

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long capacity = sc.nextLong();
            graph[u][v] += capacity;
        }

        System.out.println(fordFulkerson(graph, 0, V - 1, V));
    }
}

