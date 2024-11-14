package Div3.CFRound981Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        long ans = 0, sum = 0;
        int lastIndex = -1;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum) && map.get(sum) >= lastIndex) {
                ans++;
                lastIndex = i;
                map.clear();
                map.put(0l, i);
                sum = 0;
            } else {
                map.put(sum, i);
            }
        }

        System.out.println(ans);
    }
}