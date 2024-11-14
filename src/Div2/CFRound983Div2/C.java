package Div2.CFRound983Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(nums);
        int left = 0, ans = n - 2;
        for (int i = 2; i < n; i++) {
            while (i - left >= 2 && nums[left] + nums[left + 1] <= nums[i]) {
                left++;
            }
            ans = Math.min(ans, n - (i - left + 1));
        }
        System.out.println(ans);
    }
}

