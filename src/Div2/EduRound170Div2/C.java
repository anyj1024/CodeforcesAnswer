package Div2.EduRound170Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        Integer[] nums = new Integer[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        int left = 0, right = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int unique = 0;
        while (right < n) {
            if (right > left && nums[right] - nums[right - 1] > 1) {
                while (left < right) {
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                        unique--;
                    }
                    left++;
                }
            }
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[right]) == 1) unique++;
            while (unique > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                    unique--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        System.out.println(ans);
    }
}
