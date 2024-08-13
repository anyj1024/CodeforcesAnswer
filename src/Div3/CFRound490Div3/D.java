package Div3.CFRound490Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class D {
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
        int[] nums = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        Deque<Integer>[] dp = new Deque[m];
        for (int i = 0; i < m; i++) {
            dp[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < n; i++) {
            dp[nums[i] % m].add(i);
        }
        int z = n / m, v = -1;
        long ans = 0;
        for (int i = 0; i < m; i++) {
            while (dp[i].size() > z) {
                if (v < i) v = i;
                while (dp[v % m].size() >= z) v++;
                int sz = Math.min(dp[i].size() - z, z - dp[v % m].size());
                while (sz-- > 0) {
                    int j = dp[i].pollLast();
                    ans += v - i;
                    nums[j] += v - i;
                    dp[v % m].add(j);
                }
            }
        }
        System.out.println(ans);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}