package Div4.CFRound898Div4;

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

    private static void solve() throws IOException {
        String[] nx = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]);
        long x = Long.parseLong(nx[1]);
        long[] nums = new long[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(ns[i]);
        }

        long left = 0, right = Integer.MAX_VALUE;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (checkIsTrue(nums, x, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean checkIsTrue(long[] nums, long x, long mid) {
        long sum = 0;
        for (long num : nums) {
            sum += Math.max(mid - num, 0);
            if (sum > x) return false;
        }
        return true;
    }
}