package Div3.CFRound506Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, - 1}};
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] pairs = new int[n + 1][2];

        TreeMap<Integer, Integer> left = new TreeMap<>(), right = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
            pairs[i][0] = l;
            pairs[i][1] = r;
            left.put(l, left.getOrDefault(l, 0) + 1);
            right.put(r, right.getOrDefault(r, 0) + 1);
        }

        int L = left.lastKey(), R = right.firstKey(), ans = Math.max(0, R - L);
        for (int i = 1; i <= n; i++) {
            int l = pairs[i][0], r = pairs[i][1];
            if (l < L && r > R) continue;
            left.put(l, left.getOrDefault(l, 0) - 1);
            if (left.get(l) == 0) left.remove(l);
            right.put(r, right.getOrDefault(r, 0) - 1);
            if (right.get(r) == 0) right.remove(r);

            ans = Math.max(ans, Math.max(0, right.firstKey() - left.lastKey()));

            left.put(l, left.getOrDefault(l, 0) + 1);
            right.put(r, right.getOrDefault(r, 0) - 1);
        }

        System.out.println(ans);
    }
}