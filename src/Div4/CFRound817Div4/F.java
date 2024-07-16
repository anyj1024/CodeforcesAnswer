package Div4.CFRound817Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class F {
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
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '.') continue;
                int cnt = 0;
                List<int[]> list = new ArrayList<>();
                for (int k = Math.max(0, i - 1); k <= Math.min(n - 1, i + 1); k++) {
                    for (int l = Math.max(0, j - 1); l <= Math.min(m - 1, j + 1); l++) {
                        if (k == i && l == j) continue;
                        if (board[k][l] == '.') continue;
                        if (board[k][l] == '*') {
                            cnt++;
                            list.add(new int[]{k, l});
                        }
                    }
                }
                if (cnt != 2) {
                    System.out.println("NO");
                    return;
                }
                int x1 = list.get(0)[0], y1 = list.get(0)[1];
                int x2 = list.get(1)[0], y2 = list.get(1)[1];
                if (Math.abs(x1 - x2) > 1 || Math.abs(y1 - y2) > 1) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}