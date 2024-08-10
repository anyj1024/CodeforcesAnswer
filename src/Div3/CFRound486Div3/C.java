package Div3.CFRound486Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int k = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine()), sum = 0;
            int[] nums = new int[n];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(str[j]);
                sum += nums[j];
            }
            list.add(nums);
            sums.add(sum);
        }

        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            int[] nums = list.get(i);
            int sum = sums.get(i);
            Map<Integer, int[]> map1 = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                int curSum = sum - nums[j], index = i + 1, deleteIndex = j + 1;
                if (map.containsKey(curSum)) {
                    System.out.println("YES");
                    System.out.println(index + " " + deleteIndex);
                    int[] last = map.get(curSum);
                    System.out.println(last[0] + " " + last[1]);
                    return;
                }
                map1.put(curSum, new int[]{index, deleteIndex});
            }
            map.putAll(map1);
        }
        System.out.println("NO");

    }
}