package Div3.CFRound496Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        String[] str = br.readLine().split(" ");
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }

        System.out.println(getAns(m, n) - getAns(m + 1, n));
    }

    private static long getAns(int m, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0;
        map.put(0, 1);
        long cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < m) {
                r--;
                cnt -= 1l * map.getOrDefault(r, 0);
            } else {
                cnt += 1l * map.getOrDefault(r, 0);
                r++;
            }
            ans += cnt;
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }
}