package Div4.CFRound886Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        Integer[] nums = new Integer[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        Arrays.sort(nums);
        int max = 1, cur = 1, last = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - last > k) {
                cur = 1;
            } else {
                cur++;
            }
            max = Math.max(max, cur);
            last = nums[i];
        }

        System.out.println(n - max);
    }
}