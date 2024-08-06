package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class H2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        char[][] g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = br.readLine().toCharArray();
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);
        int ans = 0, val = 1;
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '#') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    int key = val++;
                    int value = dfs(board, i, j, key);
                    map.put(key, value);
                }
            }
        }

        Map<Integer, int[]> mapIndex = new HashMap<>();
        int[] rowCount = new int[n], colCount = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) {
                    rowCount[i]++;
                    colCount[j]++;
                    continue;
                }
                int key = board[i][j];
                int[] value = mapIndex.getOrDefault(key, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE});
                value[0] = Math.min(value[0], j);
                value[1] = Math.max(value[1], j);
                value[2] = Math.min(value[2], i);
                value[3] = Math.max(value[3], i);
                mapIndex.put(key, value);
            }
        }

        int[] rowDiff = new int[n + 1], colDiff = new int[m + 1];
        int[][] boardDiff = new int[n + 1][m + 1];
        for (Map.Entry<Integer, int[]> entry : mapIndex.entrySet()) {
            int key = entry.getKey(), count = map.get(key);
            int[] value = entry.getValue();
            int left = Math.max(0, value[0] - 1), right = Math.min(m - 1, value[1] + 1), up = Math.max(0, value[2] - 1), down = Math.min(n - 1, value[3] + 1);

            rowDiff[up] += count;
            rowDiff[down + 1] -= count;

            colDiff[left] += count;
            colDiff[right + 1] -= count;

            boardDiff[up][left] += count;
            boardDiff[down + 1][left] -= count;
            boardDiff[up][right + 1] -= count;
            boardDiff[down + 1][right + 1] += count;
        }


        for (int i = 1; i < n; i++) {
            rowDiff[i] += rowDiff[i - 1];
            boardDiff[i][0] += boardDiff[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            colDiff[i] += colDiff[i - 1];
            boardDiff[0][i] += boardDiff[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                boardDiff[i][j] += boardDiff[i - 1][j] + boardDiff[i][j - 1] - boardDiff[i - 1][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int count = rowCount[i] + colCount[j] + (board[i][j] == -1 ? -1 : 0) + rowDiff[i] + colDiff[j] - boardDiff[i][j];
                ans = Math.max(ans, count);
            }
        }

        System.out.println(ans);
    }
    private static int dfs(int[][] board, int i, int j, int val) {
        int ans = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(new int[]{i, j});

        while (!stack.isEmpty()) {
            int[] cur = stack.pollLast();
            int x = cur[0], y = cur[1];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 0) continue;

            board[x][y] = val;
            ans++;

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && board[nx][ny] == 0) {
                    stack.offerLast(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}

