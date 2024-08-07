package Div4.CFRound817Div4;

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
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[2][n];
        board[0] = br.readLine().toCharArray();
        board[1] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if ((board[0][i] == 'R' && board[1][i] != 'R') ||
                    (board[1][i] == 'R' && board[0][i] != 'R')) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}