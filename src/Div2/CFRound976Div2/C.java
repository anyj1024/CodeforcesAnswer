package Div2.CFRound976Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }


    public static void solve() throws IOException {
        String[] bcd = br.readLine().split(" ");
        long b = Long.parseLong(bcd[0]), c = Long.parseLong(bcd[1]), d = Long.parseLong(bcd[2]);

        int[] bits = new int[64];
        char[] bb = new StringBuilder(Long.toBinaryString(b)).reverse().toString().toCharArray();
        char[] cc = new StringBuilder(Long.toBinaryString(c)).reverse().toString().toCharArray();
        char[] dd = new StringBuilder(Long.toBinaryString(d)).reverse().toString().toCharArray();
        int[] bBits = new int[64], cBits = new int[64], dBits = new int[64];
        for (int i = 0; i < bb.length; i++) bBits[i] = bb[i] - '0';
        for (int i = 0; i < cc.length; i++) cBits[i] = cc[i] - '0';
        for (int i = 0; i < dd.length; i++) dBits[i] = dd[i] - '0';

        for (int i = 0; i < 63; i++) {
            int bitB = bBits[i], bitC = cBits[i], bitD = dBits[i];
            if (bitD == 0) {
                if (bitC == 0) {
                    if (bitB == 1) {
                        System.out.println(-1);
                        return;
                    }
                } else {
                    if (bitB == 1) {
                        bits[i] = 1;
                    }
                }
            } else {
                if (bitC == 0) {
                    if (bitB == 0) {
                        bits[i] = 1;
                    }
                } else {
                    if (bitB == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 63; i++) {
            if (bits[i] != 0) {
                ans |= (1l << i);
            }
        }

        System.out.println(ans);
    }
}