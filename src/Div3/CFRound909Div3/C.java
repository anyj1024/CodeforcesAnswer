package Div3.CFRound909Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }

        long ans = nums[0], sum = nums[0];
        for (int i = 1; i < n; i++) {
            if (sum < 0 || (nums[i] & 1) == (nums[i - 1] & 1)) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
