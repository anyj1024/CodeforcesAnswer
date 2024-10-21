package Div2.EduRound148DIv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] in = br.readLine().split(" ");
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(nums);
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) preSum[i] = preSum[i - 1] + nums[i - 1];

        long ans = 0;
        for (int i = 0; i <= k; i++) {
            int left = 2 * i, right = n - (k - i);
//            System.out.println(i + "  " + preSum[left] + "  ");
            ans = Math.max(ans, preSum[right] - preSum[left]);
        }
        System.out.println(ans);
    }
}
