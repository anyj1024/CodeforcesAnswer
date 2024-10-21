package Div3.CFRound891Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E {
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
        String[] input = br.readLine().split(" ");
        Integer[][] nums = new Integer[n][2];
        long total = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(input[i]);
            nums[i][1] = i;
            total += nums[i][0];
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long cur = 1;
            cur += 1l * i * nums[i][0] - sum + 1l * i;
            cur += (total - sum - nums[i][0]) - 1l * (n - i - 1) * nums[i][0] + n - i - 1;
            sum += nums[i][0];
            ans[nums[i][1]] = cur;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
