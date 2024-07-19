package Div4.CFRound835Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.*;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean found = false;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nab = br.readLine().split(" ");
        int n = Integer.parseInt(nab[0]), a = Integer.parseInt(nab[1]) - 1, b = Integer.parseInt(nab[2]) - 1;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]) - 1, v = Integer.parseInt(uvw[1]) - 1;
            int w = Integer.parseInt(uvw[2]);
            graph.get(u).add(new int[] {v, w});
            graph.get(v).add(new int[] {u, w});
        }

        Set<Integer> set = new HashSet<>();
        found = false;
        dfs(set, graph, b, a, -1, 0);

        System.out.println(found ? "YES" : "NO");
    }

    private static void dfs(Set<Integer> set, List<List<int[]>> graph, int b, int curr, int prev, int xor) {
        if (curr == b) {
            if (xor == 0) found = true;
            return;
        }
        set.add(xor);
        for (int[] edges : graph.get(curr)) {
            int next = edges[0], weight = edges[1];
            int nextXor = xor ^ weight;
            if (next != prev) {
                if (next == b) {
                    if (nextXor == 0) found = true;
                } else {
                    if (set.contains(nextXor)) found = true;
                    dfs(set, graph, b, next, curr, nextXor);
                }
            }
        }
    }

}