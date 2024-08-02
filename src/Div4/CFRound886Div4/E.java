package Div4.CFRound886Div4;

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
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        long c = Long.parseLong(nc[1]);
        String[] ns = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        long left = 1l, right = (long) Math.sqrt(c) / 2 + 1;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (!check(nums, c, mid)) {
                right = mid - 1;
            } else {
                ans = mid;
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean check(int[] nums, long c, long mid) {
        long sum = 0;
        for (int s : nums) {
            sum += (1l * s + mid * 2) * (1l * s + mid * 2);
            if (sum > c) return false;
        }
        return true;
    }
}