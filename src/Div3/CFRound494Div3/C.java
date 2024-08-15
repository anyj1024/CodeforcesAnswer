package Div3.CFRound494Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        double[] nums = new double[n];
        String[] numsStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Double.parseDouble(numsStr[i]);
        }

        double ans = -1;
        for (int i = k; i <= n; i++) {
            ans = Math.max(ans, flipWindows(nums, i));
        }

        System.out.println(ans);
    }

    private static double flipWindows(double[] nums, int k) {
        double sum = 0, ans = -1;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (right - left + 1 == k) {
                ans = Math.max(ans, sum / (right - left + 1));
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans;
    }
}