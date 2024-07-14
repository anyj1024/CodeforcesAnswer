package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = board[i][j], b = board[n - j - 1][i];
                int c = board[n - i - 1][n - j - 1], d = board[j][n - i - 1];
                int count1 = a + b + c + d - 4 * '0', count0 = 4 - count1;
                ans += Math.min(count1, count0);
            }
        }

        System.out.println(ans / 4);
    }
}