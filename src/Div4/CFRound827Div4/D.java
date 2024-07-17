package Div4.CFRound827Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 1000; i++) {
            map.put(i, new HashSet<>());
            for (int j = 1; j <= 1000; j++) {
                if (gcd(i, j) == 1) {
                    map.get(i).add(j);
                }
            }
        }
        while (t-- > 0) {
            solve(map);
        }
    }

    public static void solve(Map<Integer, Set<Integer>> map) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        Map<Integer, Integer> lastPosition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastPosition.put(nums[i], i);
        }

        int ans = -1;

        for (int num1 : lastPosition.keySet()) {
            for (int num2 : lastPosition.keySet()) {
                int min = Math.min(num1, num2);
                int max = Math.max(num1, num2);
                if (map.get(min).contains(max)) {
                    ans = Math.max(ans, lastPosition.get(num1) + lastPosition.get(num2) + 2);
                }
            }
        }

        System.out.println(ans);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}