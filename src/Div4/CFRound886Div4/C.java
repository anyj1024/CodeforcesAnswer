package Div4.CFRound886Div4;

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
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            board[i] = br.readLine().toCharArray();
        }

        boolean found = false;
        int x = 0, y = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != '.') {
                    found = true;
                    x = i;
                    y = j;
                    break;
                }
            }
            if (found) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = x; i < 8 && board[i][y] != '.'; i++) {
            sb.append(board[i][y]);
        }

        System.out.println(sb.toString());
    }
}