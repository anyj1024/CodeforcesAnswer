package Div3.CFRound481Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nw = br.readLine().split(" ");
        int n = Integer.parseInt(nw[0]), w = Integer.parseInt(nw[1]);
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int left = 0, right = w;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            if (cur + left < 0) {
                left = -cur;
            } else if (cur + right > w) {
                right = w - cur;
            }
        }

        System.out.println(right - left + 1 <= 0 ? 0 : right - left + 1);
    }
}