package Div3.CFRound984Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {
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
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String[] bc = br.readLine().split(" ");
            int b = Integer.parseInt(bc[0]), c = Integer.parseInt(bc[1]);

            map.put(b, map.getOrDefault(b, 0) + c);
        }

        List<Integer> maxRes = new ArrayList<>();
        for (int value : map.values()) {
            maxRes.add(value);
        }

        Collections.sort(maxRes, Collections.reverseOrder());
        long ans = 0;
        for (int i = 0; i < Math.min(n, maxRes.size()); i++) {
            ans += maxRes.get(i);
        }
        sb.append(ans).append("\n");
    }
}
