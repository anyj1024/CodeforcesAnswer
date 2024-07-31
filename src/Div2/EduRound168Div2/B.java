package Div2.EduRound168Div2;

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

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] board = new char[2][n];
        board[0] = br.readLine().toCharArray();
        board[1] = br.readLine().toCharArray();

        int ans = 0;
        for (int i = 0; i <= 1; i++) {
            int i1 = (i == 0 ? 1 : 0), i2 = i;
            for (int j = 1; j < n - 1; j++) {
                if (board[i1][j - 1] == 'x' && board[i1][j + 1] == 'x'
                        && board[i2][j - 1] == '.' && board[i2][j + 1] == '.'
                        && board[i2][j] == '.' && board[i1][j] == '.') {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}