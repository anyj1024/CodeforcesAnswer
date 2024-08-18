package Div2.EduRound169Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String[] s = br.readLine().split(" ");
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(s[i]);
        }

        Arrays.sort(nums, Collections.reverseOrder());
        long AlicePoints = 0, BobPoints = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                AlicePoints += nums[i];
            } else {
                if (nums[i - 1] - nums[i] <= k) {
                    BobPoints += nums[i - 1];
                    k -= nums[i - 1] - nums[i];
                } else {
                    BobPoints += nums[i] + k;
                    k = 0;
                }
            }
        }
        System.out.println(AlicePoints - BobPoints);
    }
}