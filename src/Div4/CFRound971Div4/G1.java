package Div4.CFRound971Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nkq = br.readLine().split(" ");
        int n = Integer.parseInt(nkq[0]), k = Integer.parseInt(nkq[1]), q = Integer.parseInt(nkq[2]);
        int[] nums = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(input[i - 1]) - i;
        }

        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> count = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        int left = 1, right = 1;
        while (right <= n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            int cnt = map.get(nums[right]);
            count.put(cnt - 1, count.getOrDefault(cnt - 1, 0) - 1);
            if (count.get(cnt - 1) == 0) count.remove(cnt - 1);
            count.put(cnt, count.getOrDefault(cnt, 0) + 1);
            if (right - left + 1 > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                int cnt1 = map.get(nums[left]);
                if (cnt1 == 0) map.remove(nums[left]);
                count.put(cnt1 + 1, count.getOrDefault(cnt1 + 1, 0) - 1);
                if (count.get(cnt1 + 1) == 0) count.remove(cnt1 + 1);
                count.put(cnt1, count.getOrDefault(cnt1, 0) + 1);
                left++;
            }
            if (right >= k) ans.add(k - count.lastKey());
            right++;
        }
        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);

            System.out.println(ans.get(l - 1));
        }
    }
}