package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class E {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]);
            String[] s1 = br.readLine().split(" ");
            Integer[] nums = new Integer[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }
            Arrays.sort(nums, Collections.reverseOrder());
            long[] preSum = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            for (int i = 0; i < q; i++) {
                int query = Integer.parseInt(br.readLine());
                getAns(preSum, query);
            }
        }

    }

    private static void getAns(long[] nums, int q) {
        int left = 1, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left)  / 2;
            if (nums[mid] >= q) {
                ans = mid;
                right = mid - 1;
            } else {
                left =  mid + 1;
            }
        }
        System.out.println(ans);
    }
}