package Div3.CFRound913Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] nums = new long[n][2];
        for (int i = 0; i < n; i++) {
            String[] lr = br.readLine().split(" ");
            nums[i][0] = Long.parseLong(lr[0]);
            nums[i][1] = Long.parseLong(lr[1]);
        }

        int left = 0, right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (checkIsTrue(nums, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean checkIsTrue(long[][] nums, int k) {
        long left = 0, right = k;
        for (int i = 0; i < nums.length; i++) {
            long l = nums[i][0], r = nums[i][1];
            if (l > right || r < left) return false;
            left = Math.max(left, l);
            right = Math.min(right, r);
            left -= k;
            right += k;
        }
        return true;
    }
}