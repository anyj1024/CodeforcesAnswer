package Div4.CFRound918Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                nums[i] = Integer.parseInt(ns[i]);
            } else {
                nums[i] = -Integer.parseInt(ns[i]);
            }
        }

        long preSum = 0, cnt = 0;
        Set<Long> set = new HashSet<>();
        set.add(0l);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (set.contains(preSum)) {
                cnt++;
                break;
            }
            if (cnt != 0) break;
            set.add(preSum);
        }

        System.out.println(cnt != 0 ? "YES" : "NO");
    }
}

