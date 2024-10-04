package Div3.CFRound974Div3;

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

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int ans = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && cur > 0) {
                ans++;
                cur--;
            } else {
                if (nums[i] >= k) {
                    cur += nums[i];
                }
            }
        }
        System.out.println(ans);
    }

}