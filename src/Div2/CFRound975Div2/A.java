package Div2.CFRound975Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
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
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        int cnt1 = n / 2, cnt2 = n / 2;
        if ((n & 1) == 1) cnt1++;
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                max1 = Math.max(max1, nums[i]);
            } else {
                max2 = Math.max(max2, nums[i]);
            }
        }

        System.out.println(Math.max(max1 + cnt1, max2 + cnt2));
    }

}