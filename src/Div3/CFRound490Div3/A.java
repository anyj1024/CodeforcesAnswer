package Div3.CFRound490Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
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

        int left = 0, right = n - 1;
        int ans = 0;
        while (left <= right && nums[left] <= k) {
            ans++;
            left++;
        }

        while (right >= left && nums[right] <= k) {
            ans++;
            right--;
        }

        System.out.println(ans);
    }
}