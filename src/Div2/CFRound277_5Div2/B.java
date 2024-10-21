package Div2.CFRound277_5Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums1 = new int[n];
        String[] in1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(in1[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] nums2 = new int[m];
        String[] in2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            nums2[i] = Integer.parseInt(in2[i]);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i1 = 0, i2 = 0, ans = 0;
        while (i1 < n && i2 < m) {
//            System.out.println(nums1[i1] + " " + nums2[i2]);
            if (Math.abs(nums1[i1] - nums2[i2]) <= 1) {
                ans++;
                i1++;
                i2++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else {
                i1++;
            }
        }
        System.out.println(ans);
    }
}
