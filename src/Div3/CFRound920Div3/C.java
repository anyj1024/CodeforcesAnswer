package Div3.CFRound920Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String[] nfab = br.readLine().split(" ");
        long n = Long.parseLong(nfab[0]), f = Long.parseLong(nfab[1]);
        long a = Long.parseLong(nfab[2]), b = Long.parseLong(nfab[3]);
        String[] input = br.readLine().split(" ");
        long[] nums = new long[(int) n + 1];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = Long.parseLong(input[i]);
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.min(b, (nums[i] - nums[i - 1]) * a);
            if (sum >= f) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sum <= f ? "YES" : "NO");

    }
}