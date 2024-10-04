package Div3.CFRound950Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int[] nums1 = new int[n], nums2 = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(input1[i]);
            nums2[i] = Integer.parseInt(input2[i]);
            set.add(nums2[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[] nums3 = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        String[] input3 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            nums3[i] = Integer.parseInt(input3[i]);
            map.put(nums3[i], map.getOrDefault(nums3[i], 0) + 1);
        }

        if (!set.contains(nums3[m - 1])) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) continue;
            if (!map.containsKey(nums2[i])) {
                System.out.println("NO");
                return;
            } else {
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }
            }
        }

        System.out.println("YES");
    }
}