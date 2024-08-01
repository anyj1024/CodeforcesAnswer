package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[][] grid  = new int[n][m];
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                long volume = 0;
                Deque<int[]> stack = new ArrayDeque<>();
                stack.push(new int[]{i, j});
                while (!stack.isEmpty()) {
                    int[] cur = stack.pop();
                    int x = cur[0], y = cur[1];
                    if (x < 0 || y < 0 || x >= n || y >= m || grid[x][y] == 0) continue;

                    volume += grid[x][y];
                    grid[x][y] = 0;
                    for (int[] dir : dirs) {
                        int nx = x + dir[0], ny = y + dir[1];
                        stack.push(new int[]{nx, ny});
                    }
                }

                ans = Math.max(ans, volume);
            }
        }

        System.out.println(ans);
    }
}
