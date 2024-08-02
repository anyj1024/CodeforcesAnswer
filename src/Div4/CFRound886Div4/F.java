package Div4.CFRound886Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] ns = br.readLine().split(" ");

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int step = Integer.parseInt(ns[i]);
            map.put(step, map.getOrDefault(step, 0) + 1);
        }

        for (int step : map.keySet()) {
            for (int j = step; j <= n; j += step) {
                cnt[j] += map.get(step);
                ans = Math.max(ans, cnt[j]);
            }
        }

        System.out.println(ans);
    }
}