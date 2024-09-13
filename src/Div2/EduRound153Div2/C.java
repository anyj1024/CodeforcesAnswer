package Div2.EduRound153Div2;

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
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int min = Integer.MAX_VALUE, max = nums[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > max && nums[i] < min) {
                min = Math.min(min, nums[i]);
                ans++;
            }
            max = Math.min(max, nums[i]);
        }

        System.out.println(ans);
    }
}