package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(s1[j]);
                }
            }
            getAns(grid);
        }

    }

    private static void getAns(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int sum = grid[i][j];
                for (int x = i + 1, y = j + 1; x < grid.length && y < grid[x].length; x++, y++) sum += grid[x][y];
                for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) sum += grid[x][y];
                for (int x = i - 1, y = j + 1; x >= 0 && y < grid[i].length; x--, y++) sum += grid[x][y];
                for (int x = i + 1, y = j - 1; x < grid.length && y >= 0; x++, y--) sum += grid[x][y];
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }
}