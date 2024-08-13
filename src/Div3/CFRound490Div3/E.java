package Div3.CFRound490Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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
        String[] nms = br.readLine().split(" ");
        int n = Integer.parseInt(nms[0]), m = Integer.parseInt(nms[1]), s = Integer.parseInt(nms[2]);
        List<Integer>[] graph = new List[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            String[] line = br.readLine().split(" ");
            int from = Integer.parseInt(line[0]), to = Integer.parseInt(line[1]);
            graph[from].add(to);
        }

        dfs(s, graph, visited);

        List<Pair> list = new ArrayList<>();
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            boolean[] visited2 = new boolean[n + 1];
            System.arraycopy(visited, 0, visited2, 0, visited2.length);
            int count = dfs(i, graph, visited2);
            list.add(new Pair(i, count));
        }

        Collections.sort(list, (a, b) -> b.value - a.value);

        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i).key;
            if (visited[index]) continue;

            dfs(index, graph, visited);
            ans++;
        }

        System.out.println(ans);
    }

    private static int dfs(int s, List<Integer>[] graph, boolean[] visited) {
        int ans = 1;
        visited[s] = true;
        for (int next : graph[s]) {
            if (!visited[next]) {
                ans += dfs(next, graph, visited);
            }
        }
        return ans;
    }

    static class Pair {
        int key;
        int value;

        Pair() {}

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}