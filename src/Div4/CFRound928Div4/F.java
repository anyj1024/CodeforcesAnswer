package Div4.CFRound928Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int[][] graph = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 7; j++) {
                if (line[j] == 'B') graph[i][j + 1] = 1;
            }

        }

        int ans1 = 5, ans2 = 5;
        if (checkStatus(graph, 0)) ans1 = 0;
        if (checkStatus(graph, 1)) ans2 = 0;

        for (int i1 = 1; i1 <= 49; i1 += 2) {
            int x1 = (i1 - 1) / 7 + 1, y1 = (i1 % 7 == 0) ? 7 : (i1 % 7);
            if (graph[x1][y1] == 0) continue;
            graph[x1][y1] = 0;
            if (checkStatus(graph, 0)) {
                ans1 = Math.min(ans1, 1);
            }
            if (ans1 == 0 || ans1 == 1) break;
            for (int i2 = i1 + 2; i2 <= 49; i2 += 2) {
                int x2 = (i2 - 1) / 7 + 1, y2 = (i2 % 7 == 0) ? 7 : (i2 % 7);
                if (graph[x2][y2] == 0) continue;
                graph[x2][y2] = 0;
                if (checkStatus(graph, 0)) ans1 = Math.min(ans1, 2);
                for (int i3 = i2 + 2; i3 <= 49; i3 += 2) {
                    int x3 = (i3 - 1) / 7 + 1, y3 = (i3 % 7 == 0) ? 7 : (i3 % 7);
                    if (graph[x3][y3] == 0) continue;
                    graph[x3][y3] = 0;
                    if (checkStatus(graph, 0)) ans1 = Math.min(ans1, 3);
                    for (int i4 = i3 + 2; i4 <= 49; i4 += 2) {
                        int x4 = (i4 - 1) / 7 + 1, y4 = (i4 % 7 == 0) ? 7 : (i4 % 7);
                        if (graph[x4][y4] == 0) continue;
                        graph[x4][y4] = 0;
                        if (checkStatus(graph, 0)) ans1 = Math.min(ans1, 4);
                        graph[x4][y4] = 1;
                    }
                    graph[x3][y3] = 1;
                }
                graph[x2][y2] = 1;
            }
            graph[x1][y1] = 1;
        }

        for (int i1 = 2; i1 <= 48; i1 += 2) {
            int x1 = (i1 - 1) / 7 + 1, y1 = (i1 % 7 == 0) ? 7 : (i1 % 7);
            if (graph[x1][y1] == 0) continue;
            graph[x1][y1] = 0;
            if (checkStatus(graph, 1)) {
                ans2 = Math.min(ans2, 1);
            }
            if (ans2 == 0 || ans2 == 1) break;
            for (int i2 = i1 + 2; i2 <= 48; i2 += 2) {
                int x2 = (i2 - 1) / 7 + 1, y2 = (i2 % 7 == 0) ? 7 : (i2 % 7);
                if (graph[x2][y2] == 0) continue;
                graph[x2][y2] = 0;
                if (checkStatus(graph, 1)) ans2 = Math.min(ans2, 2);
                for (int i3 = i2 + 2; i3 <= 48; i3 += 2) {
                    int x3 = (i3 - 1) / 7 + 1, y3 = (i3 % 7 == 0) ? 7 : (i3 % 7);
                    if (graph[x3][y3] == 0) continue;
                    graph[x3][y3] = 0;
                    if (checkStatus(graph, 1)) ans2 = Math.min(ans2, 3);
                    for (int i4 = i3 + 2; i4 <= 48; i4 += 2) {
                        int x4 = (i4 - 1) / 7 + 1, y4 = (i4 % 7 == 0) ? 7 : (i4 % 7);
                        if (graph[x4][y4] == 0) continue;
                        graph[x4][y4] = 0;
                        if (checkStatus(graph, 1)) ans2 = Math.min(ans2, 4);
                        graph[x4][y4] = 1;
                    }
                    graph[x3][y3] = 1;
                }
                graph[x2][y2] = 1;
            }
            graph[x1][y1] = 1;
        }

        System.out.println(ans1 + ans2);

    }

    //0 Hong 1 Lv
    private static boolean checkStatus(int[][] graph, int status) {
        if (status == 0) {
            for (int i = 2; i <= 6; i++) {
                for (int j = 2; j <= 6; j++) {
                    if ((i + j) % 2 == 1 || graph[i][j] == 0) continue;
                    int sum = graph[i + 1][j + 1] + graph[i - 1][j + 1] + graph[i + 1][j - 1] + graph[i - 1][j - 1];
                    if (sum == 4) return false;
                }
            }
        } else {
            for (int i = 2; i <= 6; i++) {
                for (int j = 2; j <= 6; j++) {
                    if ((i + j) % 2 == 0 || graph[i][j] == 0) continue;
                    int sum = graph[i + 1][j + 1] + graph[i - 1][j + 1] + graph[i + 1][j - 1] + graph[i - 1][j - 1];
                    if (sum == 4) return false;
                }
            }
        }
        return true;
    }
}
