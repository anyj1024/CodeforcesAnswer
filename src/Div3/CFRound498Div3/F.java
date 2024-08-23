package Div3.CFRound498Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs1 = new int[][]{{0, 1}, {1, 0}}, dirs2 = new int[][]{{0, -1}, {-1, 0}};
    static long[][] board;
    static Map<Long, Integer>[][] maps;
    static long ans;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]), m = Integer.parseInt(nmk[1]);
        long k = Long.parseLong(nmk[2]);
        board = new long[n][m];
        maps = new Map[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                maps[i][j] = new HashMap<>();
                board[i][j] = Long.parseLong(line[j]);
            }
        }

        int step = n + m - 2;
        ans = 0;
        dfs1(0, 0, step / 2, board[0][0]);
        dfs2(n - 1, m - 1, step - step / 2, 0, k);

        System.out.println(ans);
    }

    private static void dfs1(int x, int y, int step, long sum) {
        if (step == 0) {
            maps[x][y].put(sum, maps[x][y].getOrDefault(sum, 0) + 1);
            return;
        }
        for (int[] dir : dirs1) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            dfs1(nx, ny, step - 1, sum ^ board[nx][ny]);
        }


    }

    private static void dfs2(int x, int y, int step, long sum, long k) {
        if (step == 0) {
            ans += maps[x][y].getOrDefault(sum ^ k, 0);
            return;
        }
        sum = sum ^ board[x][y];
        for (int[] dir : dirs2) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            dfs2(nx, ny, step - 1, sum, k);
        }
    }
}