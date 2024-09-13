package Div4.CFRound971Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[n][4];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == '#') {
                    sb.append((j + 1)).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}