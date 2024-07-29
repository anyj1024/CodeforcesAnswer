package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
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
        long max = Integer.MIN_VALUE, cnt = 0, abs = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            abs += Math.abs(num);
            if (num <= 0) {
                max = Math.max(max, num);
                cnt++;
            }
            if (num >= 0) {
                min = Math.min(min, num);
            }
        }
        if ((cnt & 1) == 0) {
            System.out.println(abs);
        } else {
            System.out.println(Math.max(abs + 2 * max, abs - 2 * min));
        }
    }
}
