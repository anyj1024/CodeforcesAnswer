package Div3.CFRound498Div3;

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
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        String[] strNums = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(strNums[i]);
        }

        int left = 0, right = n - 1;
        long sum1 = 0, sum2 = 0, ans = 0;
        while (left <= right) {
            if (left != right && sum1 == sum2) {
                sum1 += nums[left++];
                sum2 += nums[right--];
            } else if (sum1 < sum2) {
                sum1 += nums[left++];
            } else {
                sum2 += nums[right--];
            }
            if (sum1 == sum2) {
                ans = sum1;
            }
        }
        System.out.println(ans);
    }
}