package Div2.CFRound877Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);

        int[][] board = new int[n][m];
        int value = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = value++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (m % 2 == 1) {
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 1) {
                    appendToSb(sb, board[i]);
                }
            }
            for (int i = 0; i < n; i++) {
                if ((i & 1) == 0) {
                    appendToSb(sb, board[i]);
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                appendToSb(sb, board[i]);
            }
        }

        System.out.println(sb);
    }

    private static void appendToSb(StringBuilder sb, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(" ");
        }
        sb.append("\n");
    }
}