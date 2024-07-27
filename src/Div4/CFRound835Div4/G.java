package Div4.CFRound835Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, a, b;
    static boolean flag;
    static Set<Integer> set = new HashSet<>();;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nab = br.readLine().split(" ");
        n = Integer.parseInt(nab[0]);
        a = Integer.parseInt(nab[1]);
        b = Integer.parseInt(nab[2]);
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]), v = Integer.parseInt(uvw[1]), w = Integer.parseInt(uvw[2]);
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});

        }
        set.clear();
        dfs(graph, a, 0, -1);

        flag = false;
        seekXorFromB(graph, b, 0, -1);
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void dfs(List<int[]>[] graph, int curr, int xor, int prev) {
        set.add(xor);
        for (int[] edge : graph[curr]) {
            int next = edge[0], weight = edge[1];
            if (next == b || next == prev) continue;
            dfs(graph, next, xor ^ weight, curr);
        }
    }

    private static void seekXorFromB(List<int[]>[] graph, int curr, int xor, int prev) {
        if (set.contains(xor) && curr != b) flag = true;
        if (flag) return;
        for (int[] edge : graph[curr]) {
            int next = edge[0], weight = edge[1];
            if (next == prev) continue;
            seekXorFromB(graph, next, xor ^ weight, curr);
        }
    }

}