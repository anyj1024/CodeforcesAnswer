package Div3.CFRound895Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(" ");
            nums[i][0] = Integer.parseInt(ab[0]);
            nums[i][1] = Integer.parseInt(ab[1]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, nums[i][0] + (nums[i][1] - 1) / 2);
        }
        System.out.println(ans);
    }
}

