package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            getAns(n, nums);
        }
    }

    private static void getAns(int n, int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        long preSum = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            map.put(1l * nums[i], map.getOrDefault(nums[i], 0) + 1);
            preSum += nums[i];
            if (preSum % 2 == 0)
                ans += map.getOrDefault(preSum / 2, 0);
        }

        System.out.println(ans);
    }
}
