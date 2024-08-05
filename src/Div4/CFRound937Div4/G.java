package Div4.CFRound937Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] genre = new String[n], writer = new String[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            genre[i] = input[0];
            writer[i] = input[1];
        }

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (genre[i].equals(genre[j]) || writer[i].equals(writer[j])) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[][] dp = new boolean[1 << n][n];

        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = true;
            dfs(dp, 1 << i, i, graph);
        }

        int ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    ans = Math.max(ans, Integer.bitCount(i));
                }
            }
        }

        System.out.println(n - ans);
    }

    private static void dfs(boolean[][] dp, int state, int cur, List<Integer>[] graph) {
        dp[state][cur] = true;
        for (int next : graph[cur]) {
            if (((1 << next) & state) != 0) continue;
            if (dp[state | (1 << next)][next]) continue;
            dfs(dp, state | (1 << next), next, graph);
        }
    }
}
