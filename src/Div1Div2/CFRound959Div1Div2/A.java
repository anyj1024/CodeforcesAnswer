package Div1Div2.CFRound959Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        if (n == 1 && m == 1) {
            System.out.println(-1);
            return;
        }

        if (n > 1) {
            for (int j = 0; j < m; j++) {
                int num = board[0][j];
                for (int i = 0; i < n - 1; i++) {
                    board[i][j] = board[i + 1][j];
                }
                board[n - 1][j] = num;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int num = board[i][0];
                for (int j = 0; j < m - 1; j++) {
                    board[i][j] = board[i][j + 1];
                }
                board[i][m - 1] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
//        System.out.println();
    }
}