package Div1Div2.CFGlobalRound27Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n + 1];
        Set<Integer> set = new HashSet<>();
        if ((n & 1) == 1) {
            ans[n - 3] = 1;
            ans[n - 2] = 3;
            ans[n - 1] = n - 1;
            ans[n] = n;
            set.addAll(Arrays.asList(1, 3, n - 1, n));
            int idx = 1;
            for (int i = 1; i <= n; i++) {
                if (!set.contains(i)) {
                    ans[idx++] = i;
                }
            }
        } else {
            if ((n & (n - 1)) == 0) {
                ans[n - 4] = 1;
                ans[n - 3] = 3;
                ans[n - 2] = n - 2;
                ans[n - 1] = n - 1;
                ans[n] = n;
                set.addAll(Arrays.asList(1, 3, n - 2, n - 1, n));
                int idx = 1;
                for (int i = 1; i <= n; i++) {
                    if (!set.contains(i)) {
                        ans[idx++] = i;
                    }
                }
            } else {
                ans[n - 2] = n;
                ans[n - 1] = n - 1;
                int sLen = Integer.toBinaryString(n).length() - 1;
                ans[n] = (1 << sLen) - 1;
                set.addAll(Arrays.asList(n - 1, n, ans[n]));
                int idx = 1;
                for (int i = 1; i <= n; i++) {
                    if (!set.contains(i)) {
                        ans[idx++] = i;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {
                res &= ans[i];
            } else {
                res |= ans[i];
            }
        }

        System.out.println(res);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}

