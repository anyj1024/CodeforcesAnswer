package Div3.CFRound498Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        String[] input = br.readLine().split(" ");
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 2; i <= n; i++) {
            int nx = Integer.parseInt(input[i - 2]);
            graph[nx].add(i);
        }
        List<Integer> path = new ArrayList<>();
        int[] subTreeCounts = new int[n + 1];
        dfs(1, graph, subTreeCounts, path);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < path.size(); i++) {
            map.put(path.get(i), i);
        }

        for (int i = 0; i < q; i++) {
            String[] uk = br.readLine().split(" ");
            int u = Integer.parseInt(uk[0]), k = Integer.parseInt(uk[1]);
            if (subTreeCounts[u] < k) {
                System.out.println(-1);
            } else {
                System.out.println(path.get(map.get(u) + k - 1));
            }
        }
    }

    private static int dfs(int cur, List<Integer>[] graph, int[] subTreeCounts, List<Integer> path) {
        path.add(cur);
        subTreeCounts[cur] = 1;
        for (int next : graph[cur]) {
            subTreeCounts[cur] += dfs(next, graph, subTreeCounts, path);
        }
        return subTreeCounts[cur];
    }
}