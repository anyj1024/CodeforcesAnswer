package Div2.CFRound912Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
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
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }

        long ans = 0, last = 0;
        for (int i = n - 1; i >= 0; i--) {
            last += nums[i];
            if (last > 0 || i == 0) {
                ans += last;
            }
        }

        System.out.println(ans);
    }
}