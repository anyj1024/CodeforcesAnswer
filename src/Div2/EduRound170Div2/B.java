package Div2.EduRound170Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int t = Integer.parseInt(br.readLine());
        int[] n = new int[t], k = new int[t];
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" ");
        for (int i = 0; i < t; i++) {
            n[i] = Integer.parseInt(in1[i]);
            k[i] = Integer.parseInt(in2[i]);
        }

        for (int i = 0; i < t; i++) {
            long result = quickPow(2, k[i]);
            System.out.println(result);
        }
    }

    public static long quickPow(long base, long exponent) {
        long result = 1;
        base = base % MOD;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % MOD;
            }
            exponent >>= 1;
            base = (base * base) % MOD;
        }
        return result;
    }
}
