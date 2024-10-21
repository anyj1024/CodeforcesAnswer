package Div3.CFRound878Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nkq = br.readLine().split(" ");
        int n = Integer.parseInt(nkq[0]), k = Integer.parseInt(nkq[1]), q = Integer.parseInt(nkq[2]);
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        long ans = 0;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] > q) {
                right++;
                left = right;
                continue;
            }
            if (right - left + 1 >= k) {
                ans += right - left + 1 - k + 1;
            }
            right++;
        }
        System.out.println(ans);
    }
}
