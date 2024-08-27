package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E1 {
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

        List<int[]> list = new ArrayList<>();
        char[][] newBoard = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != '*') continue;
                int len = 0;
                int[] cnt = new int[4];
                for (int k = 0; k < 4; k++) {
                    int[] dir = dirs[k];
                    int x = i + dir[0], y = j + dir[1];
                    while (x >= 0 && x < n && y >= 0 && y < m && board[x][y] == '*') {
                        cnt[k]++;
                        x += dir[0];
                        y += dir[1];
                    }
                }
                len = Math.min(Math.min(cnt[0], cnt[1]), Math.min(cnt[2], cnt[3]));
                if (len != 0) {
                    list.add(new int[]{i + 1, j + 1, len});
                }
            }
        }

        for (int[] r : list) {
            int x = r[0] - 1, y = r[1] - 1, len = r[2];
            for (int i = x - len; i <= x + len; i++) newBoard[i][y] = '*';
            for (int i = y - len; i <= y + len; i++) newBoard[x][i] = '*';
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(board[i]));
//            System.out.println(Arrays.toString(newBoard[i]));
//
//        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '*' && board[i][j] != newBoard[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (!flag) {
            System.out.println(-1);
            return;
        }

        System.out.println(list.size());
        for (int[] r : list) {
            System.out.println(r[0] + " " + r[1] + " " + r[2]);
        }
    }

}