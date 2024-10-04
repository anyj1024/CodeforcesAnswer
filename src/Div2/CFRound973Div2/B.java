package Div2.CFRound973Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        long sum = 0;
        for (int i = 0; i < n - 2; i++) {
            sum += nums[i];
        }
        nums[n - 2] -= sum;

        System.out.println(nums[n - 1] - nums[n - 2]);
    }
}