package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            getAns(nums);
        }
    }

    private static void getAns(int[] nums) {
        int n = nums.length, ans = 0;
        int left = 0, right = n - 1;
        long leftSum = nums[left], rightSum = nums[right];
        while (left < right) {
            if (leftSum == rightSum) {
                ans = Math.max(ans, left + 1 + (n - right));
                left++;
                right--;
                leftSum += nums[left];
                rightSum += nums[right];
            } else if (leftSum > rightSum) {
                right--;
                rightSum += nums[right];
            } else {
                left++;
                leftSum += nums[left];
            }
        }
        System.out.println(ans);
    }
}
