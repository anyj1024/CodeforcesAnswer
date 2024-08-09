package Div3.CFRound481Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        long[] nums1 = new long[n], nums2 = new long[m];
        String[] input1 = br.readLine().split(" "), input2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums1[i] = Long.parseLong(input1[i]);
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = Long.parseLong(input2[i]);
        }

        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums1[i - 1];
        }

        for (long number : nums2) {
            int left = 1, right = n;
            int ans = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] >= number) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println((ans) + " " + (number - preSum[ans - 1]));
        }
    }
}