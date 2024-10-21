package Else.CFBetaRound96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            sum += nums[i];
        }

        Arrays.sort(nums);
        int k = sum / 2 + 1, cur = 0, count = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            count++;
            if (cur >= k) {
                System.out.println(count);
                return;
            }
        }
    }
}