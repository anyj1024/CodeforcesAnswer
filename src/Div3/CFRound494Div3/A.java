package Div3.CFRound494Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int[] map = new int[101];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map[nums[i]]++;
            ans = Math.max(ans, map[nums[i]]);
        }

        System.out.println(ans);
    }
}