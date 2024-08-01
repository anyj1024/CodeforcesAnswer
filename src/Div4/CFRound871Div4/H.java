package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] ns = br.readLine().split(" ");
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = Integer.parseInt(ns[i]);
        }

        int MOD = 1000000007;
        int[][] dp = new int[n + 1][64];
        dp[0][63] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 64; j++) {
                //+ or !+
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
                dp[i][j & nums[i]] = (dp[i][j & nums[i]] + dp[i - 1][j]) % MOD;
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        int ans = k == 6 ? -1 : 0;
        for (int i = 0; i <= 63; i++) {
            if (Integer.bitCount(i) == k) ans = (ans + dp[n][i]) % MOD;
        }
        System.out.println(ans);
    }
}