package Div2.CFRound963Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Long[] nums = new Long[n];
        String[] input = br.readLine().split(" ");

        long oddMax = 0, evenCount = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
            if (nums[i] % 2 == 1) oddMax = Math.max(oddMax, nums[i]);
            else evenCount++;
        }

        if (evenCount == n || evenCount == 0) {
            System.out.println(0);
            return;
        }

        int ans1 = 0, ans2 = 0;
        long temp = oddMax;
        Arrays.sort(nums);
        for (long num : nums) {
            if (num % 2 == 0) {
                if (temp > num) {
                    ans1++;
                    temp += num;
                } else {
                    ans1 += 2;
                    temp += 2 * num;
                }
            }
        }
        Arrays.sort(nums, Collections.reverseOrder());
        temp = oddMax;
        for (long num : nums) {
            if (num % 2 == 0) {
                if (temp > num) {
                    ans2++;
                    temp += num;
                } else {
                    ans2 += 2;
                    temp += 2 * num;
                }
            }
        }

        System.out.println(Math.min(ans1, ans2));

    }
}

