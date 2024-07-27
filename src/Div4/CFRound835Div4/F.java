package Div4.CFRound835Div4;

import java.util.*;
import java.io.*;


public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] ncd = br.readLine().split(" ");
        int n = Integer.parseInt(ncd[0]), d = Integer.parseInt(ncd[2]);
        long c = Long.parseLong(ncd[1]);
        String[] ns = br.readLine().split(" ");
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(ns[i]);
        }
        Arrays.sort(nums, Collections.reverseOrder());

        int left = 0, right = d + 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, c, d, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (ans == -1) {
            System.out.println("Impossible");
        } else if (ans == d + 1) {
            System.out.println("Infinity");
        } else {
            System.out.println(ans - 1);
        }
    }

    private static boolean check(Long[] nums, long c, int d, int k) {
        if (k == 0) return 1l * d * nums[0] >= c;
        long sum = 0;
        for (int i = 0; i < d; i++) {
            if (i % k < nums.length) {
                sum += nums[(i % k)];
            }
        }
        return sum >= c;
    }
}