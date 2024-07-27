package Div3.CFRound962Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] preSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + (board[i - 1][j - 1] == '0' ? 0 : 1);
            }
        }

        int factor = k;
        int sum = factor * factor;
        int newN = n / factor;
        int[][] ans = new int[newN][newN];
        boolean found = true;
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newN; j++) {
                int r1 = i * factor + 1, c1 = j * factor + 1;
                int r2 = (i + 1) * factor, c2 = (j + 1) * factor;
                ans[i][j] = preSum[r2][c2] - preSum[r1 - 1][c2] - preSum[r2][c1 - 1] + preSum[r1 - 1][c1 - 1];
                if (ans[i][j] == 0 || ans[i][j] == sum) {
                    ans[i][j] /= sum;
                }
            }
        }

        printAns(ans);

    }

    private static void printAns(int[][] ans) {
        int n = ans.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}