package Div3.CFRound981Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        long ans = 0;
        int i = 0, j = 0;
        for (j = 0; j < n; j++) {
            int min = 0;
            int i1 = 0, j1 = j;
            while (i1 < n && j1 < n) {
                min = Math.min(min, board[i1][j1]);
                i1++;
                j1++;
            }
            ans -= min;
        }
        for (i = 1; i < n; i++) {
            int min = 0;
            int i1 = i, j1 = 0;
            while (i1 < n && j1 < n) {
                min = Math.min(min, board[i1][j1]);
                i1++;
                j1++;
            }
            ans -= min;
        }

        System.out.println(ans);
    }
}