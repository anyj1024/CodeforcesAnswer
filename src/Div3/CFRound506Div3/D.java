package Div3.CFRound506Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        long k = Long.parseLong(nk[1]);
        String[] input = br.readLine().split(" ");

        long[] nums = new long[n];
        Map<Long, Long>[] map = new Map[11];
        long[] tens = new long[11];
        tens[0] = 1;
        for (int i = 1; i < 11; i++) {
            tens[i] = (tens[i - 1] * 10) % k;
            map[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
            long key = nums[i] % k;
            int len = input[i].length();
            map[len].put(key, map[len].getOrDefault(key, 0L) + 1);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 10; j++) {
                long cur = (nums[i] * tens[j]) % k;
                long key = (k - cur) % k;
                ans += map[j].getOrDefault(key, 0L);
                if (nums[i] % k == key && input[i].length() == j) {
                    ans--;
                }
            }
        }
        System.out.println(ans);
    }
}