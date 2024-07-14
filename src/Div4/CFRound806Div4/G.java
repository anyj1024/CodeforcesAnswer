package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        long ans = 0, sum = 0;
        for (int i = -1; i < n; i++) {
            sum += (i == -1 ? 0 : (nums[i] - k));
            long cur = sum;
            for (int j = i + 1; j < Math.min(n, i + 31); j++) {
                cur += Math.max(0, nums[j] >> (j - i));
            }
            ans = Math.max(ans, cur);
        }
        System.out.println(ans);
    }
}
