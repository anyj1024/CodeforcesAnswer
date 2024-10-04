package Div2.CFRound975Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        long[] ns = new long[n], ks = new long[q];
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ns[i] = Long.parseLong(in1[i]);
        }
        for (int i = 0; i < q; i++) {
            ks[i] = Long.parseLong(in2[i]);
        }

        Map<Long, Long> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            long l = ns[i - 1], r = ns[i];
            long lc = i, rc = n - i;
            long cnt1 = lc * rc;
            map.put(cnt1, map.getOrDefault(cnt1, 0L) + r - l - 1);

            long l1c = i - 1, r1c = n - i;
            long l2c = i, r2c = n - i - 1;
            long cnt2 = l1c * r1c + l1c + r1c;
            if (i == 1) {
                map.put(cnt2, map.getOrDefault(cnt2, 0L) + 1);
            }
            long cnt3 = l2c * r2c + l2c + r2c;
            map.put(cnt3, map.getOrDefault(cnt3, 0L) + 1);
        }


        StringBuilder sb = new StringBuilder();
        for (long k : ks) {
            sb.append(map.getOrDefault(k, 0L)).append(" ");
        }
        System.out.println(sb);
    }
}