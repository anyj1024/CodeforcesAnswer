package Div3.CFRound984Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        String[] lrik = br.readLine().split(" ");
        long l = Long.parseLong(lrik[0]), r = Long.parseLong(lrik[1]);
        int i = Integer.parseInt(lrik[2]);
        long k = Long.parseLong(lrik[3]);

        long m = 1L << i;
        BigInteger total = xor(l - 1).xor(xor(r));

        long ys = ceilDiv(l - k, m);
        long ye = floorDiv(r - k, m);

        BigInteger xor = BigInteger.ZERO;
        if (ys <= ye) {
            long n = ye - ys + 1;
            BigInteger s = xor(ys - 1).xor(xor(ye));
            s = s.shiftLeft(i);
            if ((n & 1) == 1) {
                xor = s.xor(BigInteger.valueOf(k));
            } else {
                xor = s;
            }
        }

        sb.append(xor.xor(total)).append('\n');
    }

    private static BigInteger xor(long n) {
        if (n < 0) return BigInteger.ZERO;
        long mod = n % 4;
        if (mod == 0) return BigInteger.valueOf(n);
        else if (mod == 1) return BigInteger.ONE;
        else if (mod == 2) return BigInteger.valueOf(n + 1);
        else return BigInteger.ZERO;
    }

    private static long ceilDiv(long a, long b) {
        long result = a / b;
        if ((a % b != 0) && ((a ^ b) > 0)) {
            result++;
        }
        return result;
    }

    private static long floorDiv(long a, long b) {
        long result = a / b;
        if ((a % b != 0) && ((a ^ b) < 0)) {
            result--;
        }
        return result;
    }
}
