package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            long l = Long.parseLong(s[0]), r = Long.parseLong(s[1]), k = Long.parseLong(s[2]);

            getAns(l, r, k);
        }
    }

    private static void getAns(long left, long right, long k) {
        int MOD = (int) 1e9 + 7;
        long n = 0;
        if (k == 1) {
            n = 10;
        } else if (k == 2) {
            n = 5;
        } else if (k == 3) {
            n = 4;
        } else if (k == 4) {
            n = 3;
        } else if (k >= 5 && k <= 9) {
            n = 2;
        } else if (k == 10) {
            n = 1;
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }

        long l = quickPow(n, left, MOD);
        long r = quickPow(n, right, MOD);

        System.out.println(((r - l) % MOD + MOD) % MOD);
    }

    private static long quickPow(long n, long p, int MOD) {
        if (p == 0) return 1;
        if (p == 1) return n;
        long x = quickPow(n, p / 2, MOD) % MOD;
        long ans  = x * x % MOD;
        if (p % 2 == 0) {
            return ans;
        }
        return  (ans * n) % MOD;
    }
}