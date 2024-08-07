package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MOD = 1000000007;
    static final int MAX = 200000;

    static long[] factorial = new long[MAX + 1];
    static long[] invFactorial = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        precomputeFactorials(); // 预计算阶乘和逆元
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        long count0 = 0, count1 = 0;
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (s[i].equals("0")) {
                count0++;
            } else {
                count1++;
            }
        }

        long ans = 0;

        for (int i = (k + 1) / 2; i <= Math.min(k, count1); i++) {
            int n1 = i, n2 = k - i;
            if (n2 <= count0) {
                ans = (ans + comb((int) count1, n1) * comb((int) count0, n2) % MOD) % MOD;
            }
        }

        System.out.println(ans);
    }

    static void precomputeFactorials() {
        factorial[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }

        invFactorial[MAX] = modInverse(factorial[MAX], MOD);
        for (int i = MAX - 1; i >= 0; i--) {
            invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD;
        }
    }

    static long comb(int n, int k) {
        if (k > n || k < 0) return 0;
        return factorial[n] * invFactorial[k] % MOD * invFactorial[n - k] % MOD;
    }

    static long modPow(long a, long b, int mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return result;
    }

    static long modInverse(long a, int mod) {
        return modPow(a, mod - 2, mod);
    }
}