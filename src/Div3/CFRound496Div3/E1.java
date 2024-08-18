package Div3.CFRound496Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[] nums = new int[n];
        String[] str = br.readLine().split(" ");
        int idx = -1;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
            if (nums[i] == m) idx = i;
        }

        long ans = 0;
        int cnt1 = 0, cnt2 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = idx; i >= 0; i--) {
            if (nums[i] <= m) {
                cnt1++;
            } else {
                cnt2++;
            }
            int key = cnt1 - cnt2;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        ans += map.getOrDefault(0, 0) + map.getOrDefault(1, 0);
        cnt1 = 0;
        cnt2 = 0;
        for (int i = idx + 1; i < n; i++) {
            if (nums[i] <= m) {
                cnt1++;
            } else {
                cnt2++;
            }
            int key = cnt1 - cnt2;
            ans += map.getOrDefault(-key, 0);
            ans += map.getOrDefault(-key + 1, 0);
        }

        System.out.println(ans);
    }
}