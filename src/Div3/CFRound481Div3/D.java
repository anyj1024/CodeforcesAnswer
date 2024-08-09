package Div3.CFRound481Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }
        int d = nums[1] - nums[0], ans = Integer.MAX_VALUE;
        int[] used = {d - 2, d - 1, d, d + 1, d + 2};
        for (int delta : used) {
            for (int j = 0; j < 3; j++) {
                boolean found = true;
                int prev = nums[0], cur = j == 0 ? 0 : 1;
                if (j == 1) prev++;
                else if (j == 2) prev--;

                for (int i = 1; i < n; i++) {
                    int curr = nums[i];
                    if (curr - prev == delta) {
                        prev = curr;
                    } else if (curr - prev == delta + 1) {
                        prev = curr - 1;
                        cur++;
                    } else if (curr - prev == delta - 1) {
                        prev = curr + 1;
                        cur++;
                    } else {
                        found = false;
                        break;
                    }

                }

                if (found) ans = Math.min(ans, cur);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}