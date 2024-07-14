package Div4.CFRound799Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H {
// **************
//    TODO:
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] nums = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int ans = -1, left = -1, right = -1, val = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int number = entry.getKey();
            List<Integer> position = entry.getValue();

            int size = position.size(), start = position.get(0), prev = 1;
            for (int i = 0; i < size; i++) {
                int end = position.get(i);
                int cur = (i + 1) - (end + 1 - (i + 1));
                if (cur < prev) {
                    start = end;
                    prev = cur;
                }
                int res = cur - prev;
                if (res > ans) {
                    ans = res;
                    val = number;
                    left = start + 1;
                    right = end + 1;
                }
            }
        }
        System.out.println(val + " " + left + " " + right);
    }
}