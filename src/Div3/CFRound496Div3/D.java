package Div3.CFRound496Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[] cs = br.readLine().toCharArray();
        int n = cs.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int number = (cs[i - 1] - '0') % 3;
            if (number == 0) {
                dp[i] = dp[i - 1] + 1;
            } else {
                if (i >= 2) {
                    int lastNumber = (cs[i - 2] - '0') % 3;
                    if (lastNumber != number) {
                        dp[i] = dp[i - 2] + 1;
                    }
                }
                if (i >= 3) {
                    int lastNumber1 = (cs[i - 2] - '0') % 3, lastNumber2 = (cs[i - 3] - '0') % 3;
                    if (lastNumber1 == number && lastNumber2 == number) {
                        dp[i] = dp[i - 3] + 1;
                    }
                }
            }

            dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}