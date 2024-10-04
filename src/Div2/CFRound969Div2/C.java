package Div2.CFRound969Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nab = br.readLine().split(" ");
        int n = Integer.parseInt(nab[0]);
        long a = Long.parseLong(nab[1]), b = Long.parseLong(nab[2]);
        Long[] nums = new Long[n];
        long k = gcd(a, b);
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]) % k;
        }
        Arrays.sort(nums);
        long ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, nums[i] + k - nums[i + 1]);
        }

        System.out.println(ans);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
