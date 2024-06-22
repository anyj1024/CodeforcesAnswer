package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class E {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            long x = Long.parseLong(s[0]), y = Long.parseLong(s[1]), z = Long.parseLong(s[2]), k = Long.parseLong(s[3]);

            getAns(x, y, z, k);
        }
    }

    private static void getAns(long x, long y, long z, long k) {
        long ans = 0, cur = 0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (k % (i * j) == 0) {
                    cur = (x - i + 1) * (y - j + 1) * (z - k / (i * j) + 1);
                    ans = Math.max(ans, cur);
                }
            }
        }
        System.out.println(ans);
    }
}
