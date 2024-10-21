package Div2.CFRound980Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        long k = Long.parseLong(nk[1]);
        String[] input = br.readLine().split(" ");
        Long[] nums = new Long[n];
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(nums);
        long ans = 0, cur = 0, step = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == step) continue;
            if (cur + (nums[i] - step) * (n - i) >= k) {
                ans += k - cur;
                System.out.println(ans);
                return;
            }
            cur += (n - i) * (nums[i] - step);
            ans += (n - i) * (nums[i] - step);
            ans += map.getOrDefault(nums[i], 0);
            step = nums[i];
        }
        System.out.println(ans);
    }
}