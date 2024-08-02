package Div4.CFRound886Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> rows = new HashMap<>(), cols = new HashMap<>();
        Map<Integer, Integer> lean1 = new HashMap<>(), lean2 = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]), v = Integer.parseInt(uv[1]);
            ans += rows.getOrDefault(u, 0) + cols.getOrDefault(v, 0) + lean1.getOrDefault(u + v, 0) + lean2.getOrDefault(u - v, 0);
            rows.put(u, rows.getOrDefault(u, 0) + 1);
            cols.put(v, cols.getOrDefault(v, 0) + 1);
            int l1 = u + v, l2 = u - v;
            lean1.put(l1, lean1.getOrDefault(l1, 0) + 1);
            lean2.put(l2, lean2.getOrDefault(l2, 0) + 1);
        }
        System.out.println(ans * 2);
    }
}