package Div4.CFRound918Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]), v = Integer.parseInt(uvw[1]), w = Integer.parseInt(uvw[2]);
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[] {u, w});
        }
        long[] s = new long[n + 1];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            s[i + 1] = Integer.parseInt(ns[i]);
        }

        long[][] dist = new long[n + 1][1001];
        boolean[][] visited = new boolean[n + 1][1001];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], (long) 2e18 + 1);
        }
        pq.add(new long[]{0, 1, s[1]});
        dist[1][(int) s[1]] = 0;
        while (!pq.isEmpty()) {
            long[] c = pq.poll();
            long dis = c[0];
            int cur = (int) c[1], ss = (int) c[2];
            if (visited[cur][ss]) continue;
            visited[cur][ss] = true;

            for (int[] ne : graph[cur]) {
                int next = ne[0], weight = ne[1], nextS = (int) s[next];
                if (dist[next][Math.min(ss, nextS)] > dist[cur][ss] + weight * ss) {
                    dist[next][Math.min(ss, nextS)] = dist[cur][ss] + weight * ss;
                    pq.add(new long[]{dist[next][Math.min(ss, nextS)], next, Math.min(ss, nextS)});
                }
            }
        }

        long ans = (long) 2e18;
        for (int i = 1; i <= 1000; i++) {
            ans = Math.min(ans, dist[n][i]);
        }
        System.out.println(ans);
    }
}

