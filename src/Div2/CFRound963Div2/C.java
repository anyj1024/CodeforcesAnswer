package Div2.CFRound963Div2;

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
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        long[] nums = new long[n];
        String[] input = br.readLine().split(" ");
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(input[i]);
            max = Math.max(max, nums[i]);
        }

        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }

        long left = max, right = max + k - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == max) continue;
            long times = (max - nums[i]) / k;
//            System.out.println("times  " + times + "  " + left + "  " + right);
            if ((max - nums[i]) % k == 0 && (times & 1) == 1) {
                System.out.println(-1);
                return;
            }
            times += ((times & 1) == 1 ? 1 : 0);
            long l = nums[i] + times * k, r = nums[i] + times * k + k - 1;
            left = Math.max(left, l);
            right = Math.min(right, r);
//            System.out.println("times  " + times + "  " + l + "  " + r);
            if (left > right) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(left);
    }
}

