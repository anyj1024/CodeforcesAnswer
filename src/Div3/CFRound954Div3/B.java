package Div3.CFRound954Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int[][] board = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    board[i][j] = Integer.parseInt(s1[j]);
                }
            }

            getAns(board);
        }
    }

    private static void getAns(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int n1 = (i > 0) ? board[i - 1][j] : -1;
                int n2 = (j > 0) ? board[i][j - 1] : -1;
                int n3 = (i < n - 1) ? board[i + 1][j] : -1;
                int n4 = (j < m - 1) ? board[i][j + 1] : -1;

                int max = Math.max(n1, Math.max(n2, Math.max(n3, n4)));
                if (board[i][j] > max) {
                    board[i][j] = max;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}