package Div1.CFRound902Div1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        String[] np = br.readLine().split(" ");
        int n = Integer.parseInt(np[0]), p = Integer.parseInt(np[1]);
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" ");
        Integer[][] nums = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(in1[i]);
            nums[i][1] = Integer.parseInt(in2[i]);
        }

        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        long ans = 1l * n * p, count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i][1] >= p || count >= n - 1) break;
            long cur = Math.min(n - count - 1, nums[i][0]);
            ans -= (p - nums[i][1]) * cur;
            count += cur;
        }

        sb.append(ans).append("\n");
    }
}
