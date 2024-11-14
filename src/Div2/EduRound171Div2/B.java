package Div2.EduRound171Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(str[i]);
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long left = 0, right = (long) 1e18;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(nums, n, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(long[] nums, int n, long k) {
        int index = 0, count = 0;
        int res = (n & 1) == 1 ? 1 : 0;
        while (index < n) {
            if (index < n - 1 && nums[index + 1] - nums[index] <= k) {
                index += 2;
            } else {
                if (res > 0 && count == 0) {
                    index += 1;
                    count++;
                } else {
                    return false;
                }
            }
        }
        return count <= res;
    }
}
