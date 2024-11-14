package Div3.CFRound984Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
        }

        long ans = 0;
        int x = 0, y = 0, h = n, w = m;
        String tar = "1543";

        while (h > 0 && w > 0) {
            List<int[]> positions = getPos(x, y, h, w);
            StringBuilder s = new StringBuilder();

            for (int[] pos : positions) {
                s.append(grid[pos[0]].charAt(pos[1]));
            }
            ans += countStrings(s.toString(), tar);
            x += 1;
            y += 1;
            h -= 2;
            w -= 2;
        }

        sb.append(ans).append("\n");

    }

    private static List<int[]> getPos(int x, int y, int h, int w) {
        List<int[]> ans = new ArrayList<>();
        for (int j = y; j < y + w; j++) {
            ans.add(new int[]{x, j});
        }
        for (int i = x + 1; i < x + h; i++) {
            ans.add(new int[]{i, y + w - 1});
        }
        for (int j = y + w - 2; j >= y; j--) {
            ans.add(new int[]{x + h - 1, j});
        }
        for (int i = x + h - 2; i > x; i--) {
            ans.add(new int[]{i, y});
        }

        return ans;
    }

    private static int countStrings(String s, String target) {
        int n = s.length(), m = target.length();
        String ex = s + s.substring(0, m - 1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            String sub = ex.substring(i, i + m);
            if (sub.equals(target)) {
                count++;
            }
        }

        return count;
    }
}
