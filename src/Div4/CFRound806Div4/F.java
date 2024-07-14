package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class F {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
        }

        List<Integer> list = new ArrayList<>();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i] >= i) continue;
            int left = 0, right = list.size() - 1, res = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[i] > list.get(mid)) {
                    res = mid + 1;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            list.add(i);
            ans += res;
        }

        System.out.println(ans);
    }
}
