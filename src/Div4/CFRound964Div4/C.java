package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nsm = br.readLine().split(" ");
        int n = Integer.parseInt(nsm[0]), s = Integer.parseInt(nsm[1]), m = Integer.parseInt(nsm[2]);

        int[][] nums = new int[n + 2][2];
        nums[0][1] = 0;
        nums[n + 1][0] = m;
        for (int i = 1; i <= n; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
            nums[i][0] = l;
            nums[i][1] = r;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int len1 = nums[i][0] - nums[i - 1][1], len3 = nums[i + 1][0] - nums[i][1];
            max = Math.max(max, Math.max(len1, len3));
        }

        System.out.println(max >= s ? "YES" : "NO");
    }
}