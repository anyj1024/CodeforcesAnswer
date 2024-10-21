package Div2.CFRound188Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        long n = Long.parseLong(nk[0]), k = Long.parseLong(nk[1]);
        long count = (n & 1) == 1 ? n / 2 + 1 : n / 2;
        if (k <= count) {
            System.out.println(2 * k - 1);
        } else {
            System.out.println(2 * (k - count));
        }
    }
}