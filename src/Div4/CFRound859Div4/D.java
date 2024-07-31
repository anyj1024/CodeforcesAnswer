package Div4.CFRound859Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        int[] nums = new int[n];
        long[] preSum = new long[n + 1];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int l = Integer.parseInt(query[0]), r = Integer.parseInt(query[1]), k = Integer.parseInt(query[2]);

            long subSum = preSum[r] - preSum[l - 1], addSum = 1l * (r - l + 1) * k;
            long sum = preSum[n] - subSum + addSum;

            System.out.println(sum % 2 == 1 ? "YES" : "NO");
        }
    }
}