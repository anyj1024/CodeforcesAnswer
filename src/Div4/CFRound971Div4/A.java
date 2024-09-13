package Div4.CFRound971Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]);
        long ans = 10000;
        for (int c = -20; c <= 20; c++) {
            ans = Math.min(ans, c - a + b - c);
        }

        System.out.println(ans);
    }
}