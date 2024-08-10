package Div3.CFRound486Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int N = 2001;
        String[] anm = br.readLine().split(" ");
        int a = Integer.parseInt(anm[0]), n = Integer.parseInt(anm[1]), m = Integer.parseInt(anm[2]);
        int[] dp = new int[N], rain = new int[N], umbrella = new int[N];
        for (int i = 0; i < n; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
            for (int j = l; j < r; j++) {
                rain[j] = 1;
            }
        }
        for (int i= 0; i < m; i++) {
            String[] xp = br.readLine().split(" ");
            int x = Integer.parseInt(xp[0]), p = Integer.parseInt(xp[1]);
            if (umbrella[x] == 0) {
                umbrella[x] = p;
            } else {
                umbrella[x] = Math.min(umbrella[x], p);
            }
        }
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= a; i++) {
            if (rain[i - 1] == 0) {
                dp[i] = dp[i - 1];
            } else {
                for (int j = 0; j < i; j++) {
                    if (umbrella[j] != 0) {
                        dp[i] = Math.min(dp[i], dp[j] + (i - j) * umbrella[j]);
                    }
                }
            }
        }
        System.out.println(dp[a] == Integer.MAX_VALUE / 2 ? -1 : dp[a]);
    }
}