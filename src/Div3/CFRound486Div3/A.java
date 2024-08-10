package Div3.CFRound486Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(input[i - 1]);
            map.put(nums[i], i);
        }

        if (map.size() < k) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        int count = map.size();
        for (int i = 1; i <= n && map.size() >= count - k + 1; i++) {
            if (map.get(nums[i]) != i) continue;
            System.out.print(i + " ");
            map.remove(nums[i]);
        }
        System.out.println();
    }
}