package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] grid = new long[2001][2001];
    static long[][] preSum = new long[2001][2001];
    static long[] ans = new long[1000001];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= 2000; i++) {
            for (int j = 1 + count; j <= 2000; j++) {
                grid[i][j - count] = 1l * (j * (j + 1) / 2 - count) * (j * (j + 1) / 2 - count);
            }
            count++;
        }
        for (int i = 1; i <= 2000; i++) {
            for (int j = 1; j <= 2000; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i][j];
                int index = (int) Math.sqrt(grid[i][j]);
                if (index > 1000000) break;
                ans[index] = preSum[i][j];
            }
        }

        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(ans[n]);
    }
}