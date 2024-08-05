package Div4.CFRound928Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        dp = new int[200001];
        for (int i = 1; i <= 200000; i++) {
            int val = 0, k = i;
            while (k != 0) {
                val += k % 10;
                k /= 10;
            }
            dp[i] = dp[i - 1] + val;
        }
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}

