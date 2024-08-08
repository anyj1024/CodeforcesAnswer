package Div3.CFRound479Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        String[] input = br.readLine().split(" ");
        Map<Integer, TreeSet<Integer>> indexes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(input[i - 1]);
            if (!indexes.containsKey(nums[i])) {
                indexes.put(nums[i], new TreeSet<>());
            }
            indexes.get(nums[i]).add(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[n + 1];
        int max = 0, index = 0;
        for (int i = 1; i <= n; i++) {
            int value = map.getOrDefault(nums[i] - 1, -1);
            if (value == -1) dp[i] = 1;
            else dp[i] = 1 + value;
            map.put(nums[i], dp[i]);
            if (max < dp[i]) {
                max = dp[i];
                index = i;
            }
        }

        System.out.println(max);

        int prev = -1;
        for (int i = max, number = nums[index] - max + 1; i >= 1; i--) {
            int higherIndex = indexes.get(number++).higher(prev);
            System.out.print(higherIndex + " ");
            prev = higherIndex;
        }

        System.out.println();


    }

}