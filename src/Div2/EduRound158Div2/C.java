package Div2.EduRound158Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        long[] nums = new long[n];
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(in[i]);
        }

        long max = 0, min = Integer.MAX_VALUE;
        for (long num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        List<Integer> ans = new ArrayList<>();
        while (max != min) {
            if ((max & 1) == 1) {
                ans.add(0);
                max /= 2;
                min /= 2;
            } else {
                ans.add(1);
                max /= 2;
                min = (min + 1) / 2;
            }
        }

        System.out.println(ans.size());
        if (ans.size() <= n && ans.size() != 0) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }

        System.out.println();

    }
}