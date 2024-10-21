package Else.CFBetaRound2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//         int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n], n2 = new int[n][n], n5 = new int[n][n];
        int zero = -1;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(line[j]);
                board[i][j] = number;
                if (number == 0) {
                    zero = i;
                    n2[i][j] = 1;
                    n5[i][j] = 1;
                } else {
                    n2[i][j] = countDiv(number, 2);
                    n5[i][j] = countDiv(number, 5);
                }
            }
        }
        n2 = solveBoard(n2);
        n5 = solveBoard(n5);

        int[][] ans = n2[n - 1][n - 1] < n5[n - 1][n - 1] ? n2 : n5;
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(n2[i]));
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(n5[i]));
//        }
        StringBuilder sb = new StringBuilder();
        String[] path = new String[2 * n - 2];
        if (zero != -1 && ans[n - 1][n - 1] > 0) {
            sb.append(1).append('\n');
            int index = 0;
            for (int i = 0; i < zero; i++) path[index++] = "D";
            for (int i = 0; i < n - 1; i++) path[index++] = "R";
            for (int i = zero; i < n - 1; i++) path[index++] = "D";
        } else {
            sb.append(ans[n - 1][n - 1]).append('\n');
            int index1 = n - 1, index2 = n - 1;
            for (int i = 2 * n - 3; i >= 0; i--) {
                if (index1 == 0) path[i] = "R";
                else if (index2 == 0) path[i] = "D";
                else {
                    if (ans[index1 - 1][index2] < ans[index1][index2 - 1]) {
                        path[i] = "D";
                        index1--;
                    } else {
                        path[i] = "R";
                        index2--;
                    }
                }
            }
        }
        for (String p : path) sb.append(p);
        System.out.println(sb);
    }

    private static int[][] solveBoard(int[][] board) {
        int n = board.length;
        int[][] dp = new int[n][n];
        dp[0][0] = board[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        return dp;
    }

    private static int countDiv(int number, int val) {
        int ans = 0;
        while (number % val == 0) {
            number = number / val;
            ans++;
        }
        return ans;
    }

}

