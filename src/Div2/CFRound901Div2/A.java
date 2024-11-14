package Div2.CFRound901Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] abn = br.readLine().split(" ");
        long a = Long.parseLong(abn[0]), b = Long.parseLong(abn[1]);
        int n = Integer.parseInt(abn[2]);
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        long ans = b;
        for (int i = 0; i < n; i++) {
            if (nums[i] + 1 > a) {
                ans += a - 1;
            } else {
                ans += nums[i];
            }
        }

        System.out.println(ans);
    }
}

