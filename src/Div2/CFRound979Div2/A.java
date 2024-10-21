package Div2.CFRound979Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += max - min;
        }
        System.out.println(ans);
    }
}