package Div3.CFRound506Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, - 1}};
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        int cnt = 1, ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= 2 * nums[i - 1]) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
        }
        ans = Math.max(ans, cnt);
        System.out.println(ans);
    }
}