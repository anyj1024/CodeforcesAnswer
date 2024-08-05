package Div4.CFRound937Div4;

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
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i + j) % 2) == 0) {
                    grid[i][j] = '#';
                } else {
                    grid[i][j] = '.';
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(grid[i]));
//        }

        char[][] ans = new char[2 * n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int r = i * 2, c = j * 2;
                ans[r][c] = grid[i][j];
                ans[r + 1][c] = grid[i][j];
                ans[r][c + 1] = grid[i][j];
                ans[r + 1][c + 1] = grid[i][j];
            }
        }

        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}
