package Div4.CFRound827Div4;

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
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        int[] nums = new int[n], queries = new int[q];
        long[] preSum = new long[n + 1];
        int max = -1;
        String[] ns = br.readLine().split(" "), qs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(ns[i]);
            max = Math.max(max, number);
            nums[i] = max;
            preSum[i + 1] = preSum[i] + number;
        }
        for (int i = 0; i < q; i++) {
            queries[i] = Integer.parseInt(qs[i]);
        }

        for (int query : queries) {
            int left = 0, right = nums.length - 1;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= query) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.print((ans == -1 ? 0 : preSum[ans + 1]) + " ");
        }
        System.out.println();
    }

}