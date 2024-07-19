package Div4.CFRound835Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] bs = br.readLine().split(" ");
        int[] bits = new int[n];
        for (int i = 0; i < n; i++) {
            bits[i] = Integer.parseInt(bs[i]);
        }

        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + bits[i - 1];
        }

        long ans = 0, cur = 0;
        for (int i = 1; i < n; i++) {
            if (bits[i] == 0) {
                ans += preSum[i];
            }
        }
        for (int i = 0; i < n; i++) {
            int left1 = preSum[i], left0 = i - preSum[i];
            int right1 = preSum[n] - preSum[i + 1], right0 = n - i - 1 - (right1);
            if (bits[i] == 0) {
                cur = Math.max(cur, right0 - left1);
            } else {
                cur = Math.max(cur, left1 - right0);
            }
        }
        System.out.println(cur + ans);
    }

}