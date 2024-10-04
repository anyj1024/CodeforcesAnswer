package Div3.CFRound974Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        long sum = 0, max = 0;
        for (long num : nums) {
            sum += num;
            max = Math.max(max, sum);
        }

        long left = 0, right = 1l << 53;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (checkIsTrue(nums, n, sum, max, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean checkIsTrue(long[] nums, int n, long sum, long max, long k) {
        long newSum = sum + k;
        double ave = 1.0 * newSum / n / 2;
        int count = 0;
        for (long num : nums) {
            if (num < ave) {
                count++;
            }
        }
        if (max < ave) count--;

        return count > 1.0 * n / 2;
    }

}