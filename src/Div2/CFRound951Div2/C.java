package Div2.CFRound951Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            getAns(n, nums);
        }
    }

    private static void getAns(int n, long[] nums) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        List<Long> list = new ArrayList<>(set);
        long lcm = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            list.set(i, list.get(i - 1) / gcd(list.get(i - 1), list.get(i)) * list.get(i));
        }
        lcm = list.get(list.size() - 1);

        List<Long> ans = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long val = lcm / nums[i];
            sum += val;
            ans.add(val);
        }
        if (sum >= lcm) {
            System.out.println(-1);
            return;
        }
        for (long num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
