package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, - 1}};
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine()) * 2;
        char[] a = br.readLine().toCharArray();
        String as = new String(a);
        int m = a.length;
        int[] differ = new int[m];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= i; j++) {
                if (as.substring(0, j).equals(as.substring(i - j + 1, i) + (a[i] == '(' ? ')' : '('))) {
                    differ[i] = j;
                }
            }
        }

        int[][][] dp = new int[n + 1][m + 2][n / 2 + 1];
        dp[0][0][0] = 1;
        for (int i = 0; i < dp.length; i++) {
            if (i + 1 >= dp.length) continue;
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    if (dp[i][j][k] == 0) continue;
                    int i2 = i + 1;
                    for (char u = '('; u <= ')'; u++) {
                        int j2 = 0;
                        if (j == m) j2 = m;
                        else if (j < m && u == a[j]) j2 = j + 1;
                        else {
                            if (u == a[0]) j2 = 1;
                            j2 = Math.max(j2, differ[j]);
                        }
                        int k2 = k + (u == '(' ? 1 : -1);
                        if (k2 < 0 || k2 >= dp[i][j].length) continue;
                        dp[i2][j2][k2] += dp[i][j][k];
                        dp[i2][j2][k2] %= MOD;
                    }
                }
            }
        }
        System.out.println(dp[n][m][0]);
    }

}