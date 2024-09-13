package Div4.CFRound971Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        long[] nums = new long[n * 2 + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Long.parseLong(input[i - 1]);
            nums[i + n] = nums[i];
        }
        for (int i = 1; i <= 2 * n; i++) nums[i] += nums[i - 1];

        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            long l = Long.parseLong(lr[0]), r = Long.parseLong(lr[1]);

            System.out.println(calculate(nums, r) - calculate(nums, l - 1));
        }
    }

    private static long calculate(long[] nums, long k) {
        long ans = 0;
        int n = (nums.length - 1) / 2;
        long repeat = k / n, last = k - repeat * n;
        ans += repeat * nums[n];
        if (last == 0) return ans;
        repeat %= n;
        ans += nums[(int) (repeat + last)] - nums[(int) repeat];
        return ans;
    }

}