package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, - 1}};

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] left = new int[n][m], right = new int[n][m];
        int[][] up = new int[n][m], down = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '*') {
                    left[i][j] = down[i][j] = 1;
                    if (j > 0) {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                    if (i > 0) {
                        down[i][j] = down[i - 1][j] + 1;
                    }
                }
                if (board[n - i - 1][m - j - 1] == '*') {
                    right[n - i - 1][m - j - 1] = up[n - i - 1][m - j - 1] = 1;
                    if (j > 0) {
                        right[n - i - 1][m - j - 1] = right[n - i - 1][m - j] + 1;
                    }
                    if (i > 0) {
                        up[n - i - 1][m - j - 1] = up[n - i][m - j - 1] + 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int starSize = Math.min(Math.min(left[i][j], right[i][j]), Math.min(up[i][j], down[i][j]));
                if (starSize > 1) {
                    board[i][j] = '.';
                    for (int k = 0; k < starSize; k++) {
                        board[i + k][j] = board[i - k][j] = board[i][j + k] = board[i][j - k] = '.';
                    }
                    sb.append(i + 1).append(" ").append(j + 1).append(" ").append(starSize - 1).append("\n");
                    cnt++;
                }
            }
        }

        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '*') {
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (found) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }

}