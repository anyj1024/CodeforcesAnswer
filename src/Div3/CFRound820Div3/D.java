package Div3.CFRound820Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] in1  = br.readLine().split(" "), in2 = br.readLine().split(" ");
        Integer[] x = new Integer[n], nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(in1[i]);
            nums[i] = Integer.parseInt(in2[i]) - x[i];
        }

        Arrays.sort(nums);
        int left = 0, right = n - 1, ans = 0;
        for (left = 0; left < n; left++) {
            if (right > left && nums[left] + nums[right] >= 0) {
                right--;
                ans++;
            }
            if (right <= left) break;
        }
        System.out.println(ans);
    }
}
