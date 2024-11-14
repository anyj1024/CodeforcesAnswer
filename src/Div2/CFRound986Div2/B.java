package Div2.CFRound986Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nab = br.readLine().split(" ");
        long n = Long.parseLong(nab[0]), b = Long.parseLong(nab[1]), c = Long.parseLong(nab[2]);

        if (b == 0) {
            if (c >= n) {
                System.out.println(n);
            } else if (c >= n - 2) {
                System.out.println(n - 1);
            } else {
                System.out.println(-1);
            }
        } else {
            if (c >= n) {
                System.out.println(n);
            } else {
                System.out.println(n - Math.max(0, 1 + (n - c - 1) / b));
            }
        }
    }
}
