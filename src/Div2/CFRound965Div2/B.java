package Div2.CFRound965Div2;

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

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        String[] str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(str[i - 1]);
        }

        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (nums[i] == 1) {
                ans[i] = n;
            } else {
                ans[i] = nums[i] - 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}