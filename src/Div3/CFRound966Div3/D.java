package Div3.CFRound966Div3;

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
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            preSum[i + 1] = nums[i] + preSum[i];
        }
        char[] cs = br.readLine().toCharArray();

        long ans = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            while (left <= right && cs[left] != 'L') left++;
            while (left <= right && cs[right] != 'R') right--;
            if (left < right) {
                ans += preSum[right + 1] - preSum[left];
                left++;
                right--;
            }
        }

        System.out.println(ans);
    }
}