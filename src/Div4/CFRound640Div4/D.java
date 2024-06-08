package Div4.CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            getAns(nums);
        }
    }

    private static void getAns(int[] nums) {
        int left = 0, right = nums.length - 1;
        long sum1 = 0, sum2 = 0, cur1 = 0, cur2 = 0, round = 0;
        boolean f = true;
        while (left <= right) {
            if (f) {
                while (left <= right && cur1 <= cur2) {
                    cur1 += nums[left++];
                }
                cur2 = 0;
            } else {
                while (left <= right && cur1 >= cur2) {
                    cur2 += nums[right--];
                }
                cur1 = 0;
            }
            sum1 += cur1;
            sum2 += cur2;
            f = !f;
            round++;
        }

        System.out.println(round + " " + sum1 + " " + sum2);

    }

}