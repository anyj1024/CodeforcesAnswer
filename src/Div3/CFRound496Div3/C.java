package Div3.CFRound496Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C {
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

        Set<Long> set1 = new HashSet<>(), set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (long k = 1; k <= (1l << 32); k *= 2) {
                if (set2.contains(k - nums[i])) {
                    set1.add(k - nums[i]);
                    set1.add((long) nums[i]);
                }
            }
            set2.add((long) nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!set1.contains((long) nums[i])) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}