package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            char[][] board = new char[n][m];

            for (int i = 0; i < n; i++) {
                board[i] = br.readLine().toCharArray();
            }

            getAns(n, m, board);
        }
    }

    private static void getAns(int n, int m, char[][] board) {
        int row = -1, col = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') {
                    row = i;
                    col = j;
                    break;
                }
            }
            if (row != -1) break;
        }

        int row1 = -1;
        for (int i = row; i < n; i++) {
            if (board[i][col] == '.') break;
            row1 = i;
        }

        row = (row + row1) / 2;

        System.out.println((row + 1) + " " + (col + 1));
    }
}
