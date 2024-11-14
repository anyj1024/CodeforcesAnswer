package Div3.CFRound984Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[]input = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < n; i++) {
            int abs = Math.abs(nums[i - 1] - nums[i]);
            if (abs != 5 && abs != 7) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
