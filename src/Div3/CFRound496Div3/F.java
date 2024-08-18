package Div3.CFRound496Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dist;
    static int n, m, k;
    static List<StringBuilder> list;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmk = br.readLine().split(" ");
        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        k = Integer.parseInt(nmk[2]);

        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1, b = Integer.parseInt(ab[1]) - 1;
            graph[a].add(new Edge(b, i));
            graph[b].add(new Edge(a, i));
        }

        dist = new int[n];
        Arrays.fill(dist, -1);
        dist[0] = 0;
        int curDistance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (Edge next : graph[cur]) {
                    if (dist[next.dest] == -1) {
                        dist[next.dest] = curDistance + 1;
                        queue.add(next.dest);
                    }
                }
            }
            curDistance++;
        }
//        System.out.println(Arrays.toString(dist));
        boolean[] visited = new boolean[m];
        list = new ArrayList<>();

        permuteAndGetAns(1, visited);

        System.out.println(list.size());
        for (StringBuilder sb : list) {
            System.out.println(sb.toString());
        }
    }

    private static void permuteAndGetAns(int index, boolean[] visited) {
        if (k == 0) return;
        if (index == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(visited[i] ? 1 : 0);
            }
            list.add(new StringBuilder(sb));
            k--;
            return;
        }

        for (Edge edge : graph[index]) {
            if (dist[index] == dist[edge.dest] + 1) {
                visited[edge.index] = true;
                permuteAndGetAns(index + 1, visited);
                visited[edge.index] = false;
            }
        }

    }

    static class Edge {
        int dest, index;

        public Edge(int dest, int index) {
            this.dest = dest;
            this.index = index;
        }
    }
}