package Div3.CFRound486Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Long[] nums = new Long[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(nums);
        Set<Long> set = new HashSet<>();
        set.add(nums[0]);
        long ans = 1, val1 = -1, val2 = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 31; j++) {
                long num1 = nums[i] - (1 << j), num2 = nums[i] - 2l * (1 << j);
                if (set.contains(num1) && set.contains(num2)) {
                    System.out.println(3);
                    System.out.println(num2 + " " + num1 + " " + nums[i]);
                    return;
                } else if (set.contains(num1)) {
                    ans = 2;
                    val2 = num1;
                    val1 = nums[i];
                }
                set.add(nums[i]);
            }
        }

        System.out.println(ans);
        if (ans == 1) {
            System.out.println(nums[0]);
        } else {
            System.out.println(val1 + " " + val2);
        }
    }
}