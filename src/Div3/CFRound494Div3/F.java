package Div3.CFRound494Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] ss = br.readLine().split(" ");

        int length = n - 1 + Arrays.stream(ss).mapToInt(String::length).sum();

        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ss[i].equals(ss[j])) {
                    if (i == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
            }
        }

        int ans = length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int d = 1; d <= i; d++) {
                sum += ss[i - d + 1].length();
                int count = 0;
                for (int j = i - d; j >= 0;) {
                    if (dp[j][i] >= d) {
                        count++;
                        j -= d;
                    } else {
                        j--;
                    }
                }
                if (count > 0) {
                    count++;
                    int cur = length - count * sum + count;
                    ans = Math.min(ans, cur);
                }
            }
        }
        System.out.println(ans);
    }
}