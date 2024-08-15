package Div3.CFRound966Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]), m = Integer.parseInt(nmk[1]), k = Integer.parseInt(nmk[2]);
        int w = Integer.parseInt(br.readLine());
        Long[] height = new Long[w];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < w; i++) {
            height[i] = Long.parseLong(input[i]);
        }
        Arrays.sort(height);
        int rowMax = Math.min(m - k + 1, k), colMax = Math.min(n - k + 1, k);

        long[][] board = new long[n][m];
        int rl = 0, rr = n - 1;
        int rCount = 1;
        while (rl <= rr) {
            int cl = 0, cr = m - 1;
            int cCount = 1;
            while (cl <= cr) {
                board[rl][cl] = Math.min(rCount, colMax) * Math.min(rowMax, cCount);
                board[rl][cr] = Math.min(rCount, colMax) * Math.min(rowMax, cCount);

                board[rr][cl] = Math.min(rCount, colMax) * Math.min(rowMax, cCount);
                board[rr][cr] = Math.min(rCount, colMax) * Math.min(rowMax, cCount);
                cl++;
                cr--;
                cCount++;
            }
            rl++;
            rr--;
            rCount++;
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(board[i]));
            for (int j = 0; j < m; j++) {
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
            }
        }


//        System.out.println(map.toString());
        long ans = 0;
        for (int i = w - 1; i >= 0; i--) {
            long lastKey = map.lastKey();
            ans += 1l * lastKey * height[i];
            map.put(lastKey, map.get(lastKey) - 1);
            if (map.get(lastKey) == 0) {
                map.remove(lastKey);
            }
        }

        System.out.println(ans);
    }
}