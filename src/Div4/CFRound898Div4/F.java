package Div4.CFRound898Div4;

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
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        long k = Long.parseLong(nk[1]);
        long[] as = new long[n], hs = new long[n];
        String[] a = br.readLine().split(" "), h = br.readLine().split(" ");
        long ans = 0;
        for (int i = 0; i < n; i++) {
            as[i] = Long.parseLong(a[i]);
            if (as[i] <= k) ans = 1;
            hs[i] = Long.parseLong(h[i]);
        }

        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + as[i - 1];
        }

        long left = 0, right = n;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (checkIsTrue(preSum, hs, k, mid)) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean checkIsTrue(long[] preSum, long[] hs, long k, long mid) {
        int n = hs.length;
        int left = 0, right = 0;
        while (right < n) {
            if (left < right && hs[right - 1] % hs[right] != 0) {
                left = right;
                continue;
            }
            if (right - left + 1 == mid) {
                long sum = preSum[right + 1] - preSum[left];
                if (sum <= k) return true;
                left++;
            }
            right++;
        }
        return false;
    }
}