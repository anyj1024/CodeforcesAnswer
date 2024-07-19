package Div4.CFRound835Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        int max = Math.max(nums[0], nums[1]), secondMax = Math.min(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            if (nums[i] >= max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == max) {
                System.out.print((nums[i] - secondMax) + " ");
            } else {
                System.out.print((nums[i] - max) + " ");
            }
        }
        System.out.println();
    }

}