package Div2.CFRound892Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
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
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(input[j]);
                if (value < first) {
                    second = first;
                    first = value;
                } else if (value < second) {
                    second = value;
                }
            }
            nums[i][0] = first;
            nums[i][1] = second;
        }

        long ans = 0, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans += nums[i][1];
            min1 = Math.min(min1, nums[i][0]);
            min2 = Math.min(min2, nums[i][1]);
        }
        sb.append(ans - min2 + min1).append("\n");
    }
}
