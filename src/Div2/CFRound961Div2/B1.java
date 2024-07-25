package Div2.CFRound961Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class B1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        Long m = Long.parseLong(nm[1]);
        int[] nums = new int[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        Set<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long ans = 0;
        for (int key : set) {
            int nextKey = key + 1;
            long sum = 0;
            if (map.containsKey(nextKey)) {
                int cnt1 = map.get(key), cnt2 = map.get(nextKey);
                int i = 0, j = cnt2;
                while (i <= cnt1 && j >= 0) {
                    long val = 1l * i * key + 1l * j * nextKey;
                    if (val > m) {
                        j--;
                        continue;
                    }
                    sum = Math.max(sum, val);
                    i++;
                }
            } else {
                int count = map.get(key);
                long maxCount = m / key;
                if (count > maxCount) {
                    sum = maxCount * key;
                } else {
                    sum = 1l * count * key;
                }
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);

    }
}