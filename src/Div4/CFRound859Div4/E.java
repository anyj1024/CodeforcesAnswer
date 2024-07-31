package Div4.CFRound859Div4;

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

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        long[] preSum = new long[n + 1];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            StringBuilder input = new StringBuilder();
            input.append("? " + (mid - left + 1));
            for (int i = left; i <= mid; i++) input.append(" " + i);
            System.out.println(input.toString());
            long sum = Long.parseLong(br.readLine());
            if (sum == preSum[mid] - preSum[left - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("! " + left);
        System.out.flush();
    }
}