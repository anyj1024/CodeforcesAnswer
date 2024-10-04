package Div2.CFRound973Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        long n = Long.parseLong(br.readLine());
        String[] xy = br.readLine().split(" ");
        long x = Long.parseLong(xy[0]), y = Long.parseLong(xy[1]);

        long cnt1 = (n + x - 1) / x, cnt2 = (n + y - 1) / y;

        System.out.println(Math.max(cnt1, cnt2));
    }
}