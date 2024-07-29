package Div1Div2.PinelyRound4Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] ns = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        List<Integer> ans = new ArrayList<>();
        int steps = 0;
        while (!check(nums) && steps <= 40) {
            int max = Arrays.stream(nums).max().getAsInt();
            int x = (max == 1 ? 1 : max / 2);
            ans.add(x);
            for (int i = 0; i < n; i++) {
                nums[i] = Math.abs(nums[i] - x);
            }
            steps++;
//            System.out.println(Arrays.toString(nums));
        }

        if (check(nums)) {
            System.out.println(steps);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static boolean check(int[] nums) {
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }

}