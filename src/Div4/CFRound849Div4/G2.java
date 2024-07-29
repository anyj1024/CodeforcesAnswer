package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]), c = Integer.parseInt(nc[1]);
        Long[][] nums = new Long[n + 1][2];
        nums[0][0] = 0l;
        nums[0][1] = 0l;
        String[] ns = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            Long number = Long.parseLong(ns[i - 1]);
            nums[i][0] = Math.min(number + i, number + n - i + 1);
            nums[i][1] = number + i;
        }
        Arrays.sort(nums, (a, b) -> a[0] - b[0] > 0 ? 1 : -1);

        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i][0];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int cur = 0;
            if (nums[i][1] <= c) {
                int left = 0, right = n;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    long sum = preSum[mid];
                    if (mid >= i) {
                        sum -= nums[i][0];
                    }
                    if (sum + nums[i][1] <= c) {
                        cur = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                cur += (cur >= i ? 0 : 1);
            }
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}