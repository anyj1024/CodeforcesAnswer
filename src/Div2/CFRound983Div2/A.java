package Div2.CFRound983Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n * 2];
        String[] input = br.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            count += nums[i];
        }

        int max = Math.min(count, 2 * n - count);
        int min = count % 2;

        System.out.println(min + " " + max);
    }
}
