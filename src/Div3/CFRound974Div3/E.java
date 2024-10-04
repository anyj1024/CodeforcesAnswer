package Div3.CFRound974Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    private static void solve() throws IOException {
        String[] nmh = br.readLine().split(" ");
        int n = Integer.parseInt(nmh[0]), m = Integer.parseInt(nmh[1]), h = Integer.parseInt(nmh[2]);
        boolean[] hasHorse = new boolean[n + 1];
        String[] horses = br.readLine().split(" ");
        for (int i = 0; i < h; i++) {
            hasHorse[Integer.parseInt(horses[i])] = true;
        }

        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]), v = Integer.parseInt(uvw[1]), w = Integer.parseInt(uvw[2]);
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        long[][] distMarian = new long[n + 1][2];
        long[][] distRobin = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distMarian[i], INF);
            Arrays.fill(distRobin[i], INF);
        }

        dijkstra(1, distMarian, graph, hasHorse);
        dijkstra(n, distRobin, graph, hasHorse);


        long result = INF;
        for (int i = 1; i <= n; i++) {
            long step1 = Math.min(distMarian[i][0], distMarian[i][1]);
            long step2 = Math.min(distRobin[i][0], distRobin[i][1]);
            if (step1 == INF || step2 == INF) continue;
            result = Math.min(result, Math.max(step1, step2));
        }
//        for (int i = 1; i <= n; i++) {
//            System.out.println(distMarian[i][0] + " " + distMarian[i][1]);
//            System.out.println(distRobin[i][0] + " " + distRobin[i][1]);
//        }
        out.println(result == INF ? -1 : result);
    }

    private static void dijkstra(int start, long[][] dist, List<int[]>[] graph, boolean[] hasHorse) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{start, 0, 0}); // {v, d, h}
        dist[start][0] = 0;
        if (hasHorse[start]) {
            pq.offer(new long[]{start, 0, 1});
            dist[start][1] = 0;
        }

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long v = cur[0], d = cur[1], horse = cur[2];

            if (d > dist[(int) v][(int) horse]) continue;

            for (int[] edge : graph[(int) v]) {
                int to = edge[0], weight = edge[1];
                long newDist = d + (horse == 1 ? weight / 2 : weight);
                if (newDist < dist[to][(int) horse]) {
                    dist[to][(int) horse] = newDist;
                    pq.offer(new long[]{to, newDist, horse});
                }
            }

            if (hasHorse[(int) v] && horse == 0 && d < dist[(int) v][1]) {
                dist[(int) v][1] = d;
                pq.offer(new long[]{v, d, 1});
            }
        }
    }
}