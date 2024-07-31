package Div4.CFRound859Div4;

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

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] & 1) == 1) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }

        System.out.println(sum2 > sum1 ? "YES" : "NO");
    }
}
