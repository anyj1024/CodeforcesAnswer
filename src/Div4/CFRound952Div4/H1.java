package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class H1 {
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    int key = val++;
                    int value = dfs(board, i, j, key);
                    map.put(key, value);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (board[i][j] == -1) count++;
                else set.add(board[i][j]);
                if (i > 0) if (board[i - 1][j] != -1) set.add(board[i - 1][j]);
                if (i < n - 1) if (board[i + 1][j] != -1) set.add(board[i + 1][j]);
            }
            for (int key : set) {
                count += map.get(key);
            }
            ans = Math.max(count, ans);
        }
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (board[j][i] == -1) count++;
                else set.add(board[j][i]);
                if (i > 0) if (board[j][i - 1] != -1) set.add(board[j][i - 1]);
                if (i < m - 1) if (board[j][i + 1] != -1) set.add(board[j][i + 1]);
            }
            for (int key : set) {
                count += map.get(key);
            }
            ans = Math.max(count, ans);
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

