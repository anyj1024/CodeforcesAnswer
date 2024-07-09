package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
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
        Arrays.sort(nums);
        int val = nums[0];
        long ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans += nums[i] - val;
        }
        System.out.println(ans);
    }
}