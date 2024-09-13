package Div4.CFRound971Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
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
        long n = Long.parseLong(nk[0]), k = Long.parseLong(nk[1]);

        long sum = (k + k + n - 1) * n / 2, target = sum / 2;
        long left = k, right = k + n - 1;
        long l = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if ((k + mid) * (mid - k + 1) / 2 >= target) {
                l = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        long l1 = l, l2 = l - 1;
        long sum1 = (l1 + k) * (l1 - k + 1) / 2, sum2 = (l2 + k) * (l2 - k + 1) / 2;

        System.out.println(Math.min(Math.abs(sum - 2 * sum1), Math.abs(sum - 2 * sum2)));
    }

}