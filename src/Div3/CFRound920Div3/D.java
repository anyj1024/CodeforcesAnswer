package Div3.CFRound920Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        Integer[] nums1 = new Integer[n], nums2 = new Integer[m];
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(in1[i]);
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = Integer.parseInt(in2[i]);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        long ans = 0;
        for (int i = 0, j = n - 1, x = 0, y = m - 1; i <= j;) {
            int left = nums2[x], right = nums2[y];
            if (Math.abs(nums1[i] - right) < Math.abs(nums1[j] - left)) {
                ans += Math.abs(nums1[j] - left);
                x++;
                j--;
            } else {
                ans += Math.abs(nums1[i] - right);
                i++;
                y--;
            }
        }
        System.out.println(ans);
    }
}
