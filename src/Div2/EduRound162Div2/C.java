package Div2.EduRound162Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] in = br.readLine().split(" ");
        int[] nums = new int[n];
        long[] preSum = new long[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(in[i]);
            preSum[i + 1] = preSum[i] + nums[i];
            cnt[i + 1] = cnt[i] + (nums[i] == 1 ? 1 : 0);
        }

        for (int i = 1; i <= k; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);

            long sum = preSum[r] - preSum[l - 1], count = cnt[r] - cnt[l - 1];
            if (sum < count + r - l + 1 || l >= r) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}