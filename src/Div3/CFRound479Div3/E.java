package Div3.CFRound479Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        List<Integer>[] graph = new List[n + 1];
        int[] degrees = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]), v = Integer.parseInt(uv[1]);
            graph[u].add(v);
            degrees[u]++;
            graph[v].add(u);
            degrees[v]++;
        }

//        System.out.println(Arrays.toString(degrees));
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                long[] values = dfs(graph, visited, degrees, i);
//                System.out.println("v0 " + values[0] + "  v1 " + values[1]);
                ans += (values[1] % values[0] == 0 && values[1] / values[0] == 2) ? 1 : 0;
            }
        }

        System.out.println(ans);
    }

    private static long[] dfs(List<Integer>[] graph, boolean[] visited, int[] degrees, int cur) {
        long[] res = new long[2];
        res[0] += 1;
        res[1] += degrees[cur] == 2 ? 2 : 200001;
        visited[cur] = true;

        for (int next : graph[cur]) {
            if (!visited[next]) {
                long[] nextRes = dfs(graph, visited, degrees, next);
                res[0] += nextRes[0];
                res[1] += nextRes[1];
            }
        }

        return res;
    }

}