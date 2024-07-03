package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s1 = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]);
            String[] s2 = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s2[i]);
            }

            getAns(nums, k);
        }

    }

    private static void getAns(int[] nums, int k) {
        int[] cnt = new int[31];
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            for (int j = 0; j < 31; j++) {
                cnt[j] += (number & (1 << j)) != 0 ? 1 : 0;
            }
        }
//        System.out.println(Arrays.toString(cnt));
        for (int i = 30; i >= 0 && k >= 0; i--) {
            if (cnt[i] + k >= nums.length) {
                int n = nums.length - cnt[i];
                k -= n;
                cnt[i] += n;
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if (cnt[i] == nums.length) {
                ans ^= (1 << i);
            }
        }
        System.out.println(ans);
    }
}