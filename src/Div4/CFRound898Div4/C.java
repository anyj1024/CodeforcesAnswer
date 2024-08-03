package Div4.CFRound898Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[][] board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 'X') {
                    if (i == 0 || i == 9 || j == 0 || j == 9) {
                        ans += 1;
                    } else if (i == 1 || j == 1 || i == 8 || j == 8) {
                        ans += 2;
                    } else if (i == 2 || j == 2 || i == 7 || j == 7) {
                        ans += 3;
                    } else if (i == 3 || j == 3 || i == 6 || j == 6) {
                        ans += 4;
                    } else {
                        ans += 5;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}