package Div4.CFRound952Div4;

import java.util.*;
import java.io.*;

public class F{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s1 = br.readLine().split(" ");
            String[] s2 = br.readLine().split(" ");
            String[] s3 = br.readLine().split(" ");
            long h = Long.parseLong(s1[0]);
            int n = Integer.parseInt(s1[1]);
            Long[][] nums = new Long[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = Long.parseLong(s2[i]);
                nums[i][1] = Long.parseLong(s3[i]);
            }
            getAns(h, n, nums);
        }
    }
    private static void getAns(long h, int n, Long[][] nums) {
        long left = 1, right = 1;
        long maxTime = -1;
        Map<Long, Long> map = new HashMap<>();
        for (Long[] number : nums) {
            long a = number[0], c = number[1];
            map.put(c, map.getOrDefault(c, 0l) + a);
            maxTime = Math.max(maxTime, c);
        }
        right = ((h + map.get(maxTime) - 1) / map.get(maxTime)) * maxTime;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (checkIsTrue(h, map, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
    private static boolean checkIsTrue(long h, Map<Long, Long> map, long mid) {
        long h1 = h;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            long c = entry.getKey(), a = entry.getValue();
            h -= ((mid + c - 1) / c) * a;
            if (h <= 0 || h1 <= h) return true;
        }
        return false;
    }
}