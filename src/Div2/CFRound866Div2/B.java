package Div2.CFRound866Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String s = br.readLine();
        char[] cs = s.toCharArray();
        long n0 = 0, n1 = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                n0++;
            } else {
                n1++;
            }
        }

        if (n1 == 0) {
            System.out.println(0);
            return;
        }
        if (n1 == cs.length) {
            System.out.println(n1 * n1);
            return;
        }

        s += s;
        long ans = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ans++;
            } else {
                ans = 0;
            }
            res = Math.max(ans, res);
        }

        if (res % 2 == 0) {
            ans = (res / 2) * (res / 2 + 1);
        } else {
            ans = (res / 2 + 1) * (res / 2 + 1);
        }
        System.out.println(ans);
    }
}
