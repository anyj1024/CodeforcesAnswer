package Div4.CFRound859Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Integer[] nums = new Integer[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        Arrays.sort(nums);
        long sum = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > sum) {
                System.out.println("NO");
                return;
            }
            if (i != 0) sum += nums[i];
        }
        System.out.println("YES");

    }
}