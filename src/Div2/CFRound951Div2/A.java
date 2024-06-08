package Div2.CFRound951Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
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

            getAns(n, nums);
        }
    }

    private static void getAns(int n, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int val = Math.max(nums[i], nums[i - 1]);
            min = Math.min(min, val);
        }
        System.out.println(min - 1);
    }
}
