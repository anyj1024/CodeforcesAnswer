package Div1Div2.PinelyRound4Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] ns = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            int left = i, right = n - i - 1;
            if ((left & 1) == 0 && (right & 1) == 0) {
                ans = Math.max(ans, nums[i]);
            }
        }
        System.out.println(ans);
    }
}