package Div2.CFRound961Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        long m = Long.parseLong(nm[1]);
        long[] a = new long[n], c = new long[n];
        String[] as = br.readLine().split(" ");
        String[] cs = br.readLine().split(" ");
        Map<Long, Long> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(as[i]);
            c[i] = Long.parseLong(cs[i]);
            cnt.put(a[i], c[i]);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long cnt1 = cnt.getOrDefault(a[i], 0l);
            long cnt2 = cnt.getOrDefault(a[i] + 1, 0l);
            long tempSum = cnt1 * a[i] + cnt2 * (a[i] + 1);
            if (tempSum <= m) ans = Math.max(ans, tempSum);

            long k1 = Math.min(cnt1, m / a[i]);
            tempSum = k1 * a[i];
            long k2 = Math.min(cnt2, (m - tempSum) / (a[i] + 1));
            tempSum += k2 * (a[i] + 1);

            if (k1 > 0 && k2 < cnt2 && tempSum < m) {
                long delta = Math.min(Math.min(k1, cnt2 - k2), m - tempSum);
                k1 -= delta;
                k2 += delta;
                tempSum += delta;
            }

            ans = Math.max(ans, tempSum);
        }
        System.out.println(ans);
    }
}