package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String[] ns = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        int ans = 0, length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                length = 0;
            } else {
                length++;
            }
            ans = Math.max(ans, length);
        }
        System.out.println(ans);
    }
}