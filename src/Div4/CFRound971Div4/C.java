package Div4.CFRound971Div4;

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
        String[] xyk = br.readLine().split(" ");
        long x = Long.parseLong(xyk[0]), y = Long.parseLong(xyk[1]);
        long k = Long.parseLong(xyk[2]);

        long count1 = (x + k - 1) / k, count2 = (y + k - 1) / k;
        if (count1 > count2) {
            System.out.println(2 * count1 - 1);
        } else {
            System.out.println(2 * count2);
        }
    }
}