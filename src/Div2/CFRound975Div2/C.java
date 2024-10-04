package Div2.CFRound975Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        long k = Long.parseLong(nk[1]);
        String[] in = br.readLine().split(" ");
        Long[] nums = new Long[n];
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(in[i]);
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

//        System.out.println(Arrays.toString(nums) + "  " + max);
        for (int i = n; i >= 1; i--) {
            long count = max * i;
//            System.out.println(max + "  " + n + " sss " + (sum + k));
            if ((sum >= count && sum % i == 0) || (sum / i * i + i - sum <= k && sum + k >= count)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(1);
    }
}