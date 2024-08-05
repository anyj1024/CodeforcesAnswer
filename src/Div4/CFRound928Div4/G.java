package Div4.CFRound928Div4;

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
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        String[] ns = br.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            int node = Integer.parseInt(ns[i - 2]);
            graph[node].add(i);
            graph[i].add(node);
        }
        char[] types = br.readLine().toCharArray();

        int[][] dp = new int[3][n + 1];
        dfs(graph, dp, types, 1, -1);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    private static void dfs(List<Integer>[] graph, int[][] dp, char[] types, int curr, int prev) {
        if (types[curr - 1] == 'P') {
            dp[0][curr] = 0;
            dp[1][curr] = Integer.MAX_VALUE / 2;
        } else if (types[curr - 1] == 'S') {
            dp[1][curr] = 0;
            dp[0][curr] = Integer.MAX_VALUE / 2;
        } else {
            dp[1][curr] = 0;
            dp[0][curr] = 0;
        }

        for (int next : graph[curr]) {
            if (next == prev) continue;
            dfs(graph, dp, types, next, curr);

            if (types[curr - 1] == 'P') {
                dp[0][curr] += Math.min(dp[0][next], dp[1][next] + 1);
            } else if (types[curr - 1] == 'S') {
                dp[1][curr] += Math.min(dp[1][next], dp[0][next] + 1);
            } else {
                dp[0][curr] += Math.min(dp[0][next], dp[1][next] + 1);
                dp[1][curr] += Math.min(dp[1][next], dp[0][next] + 1);
            }
        }
    }
}
