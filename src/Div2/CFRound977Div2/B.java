package Div2.CFRound977Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nx = br.readLine().split(" ");
        int n = Integer.parseInt(nx[0]), x = Integer.parseInt(nx[1]);
        long[] nums = new long[n];
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) nums[i] = Long.parseLong(in[i]);

        Map<Long, TreeMap<Long, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long key = nums[i] % x;
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            map.get(key).put(nums[i], map.get(key).getOrDefault(nums[i], 0) + 1);
        }

        long ans = 0;
        while (map.containsKey(ans % x)) {
            long key1 = ans % x;
            TreeMap<Long, Integer> subMap = map.get(key1);
            Long key2 = subMap.floorKey(ans);
            if (key2 == null) {
                break;
            }
            map.get(key1).put(key2, map.get(key1).get(key2) - 1);
            if (map.get(key1).get(key2) == 0) {
                map.get(key1).remove(key2);
            }
            ans++;
        }

        System.out.println(ans);
    }

}
