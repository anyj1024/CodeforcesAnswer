package Div2.CFRound914Div2;

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

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        long[][] nums = new long[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = Long.parseLong(in[i]);
            nums[i][1] = i;
        }
        Arrays.sort(nums, (a, b) -> Long.compare(a[0], b[0]));

        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1][0];
        }

        int[] ans = new int[n];
        ans[(int) nums[n - 1][1]] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (preSum[i + 1] >= nums[i + 1][0]) {
                ans[(int) nums[i][1]] = ans[(int) nums[i + 1][1]];
            } else {
                ans[(int) nums[i][1]] = i;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(ans[i]).append(" ");
        }
        System.out.println(stringBuilder.toString().trim());
    }

}
