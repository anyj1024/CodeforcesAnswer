package Div3.CFRound966Div3;

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
        int n = Integer.parseInt(br.readLine());
        if (n <= 100) {
            System.out.println("NO");
            return;
        }

        String s = String.valueOf(n);
        int prev = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        int post = 0;
        if (prev != 10 || (s.length() >= 3 && s.charAt(2) == '0')) {
            System.out.println("NO");
            return;
        }
        for (int i = 2; i < s.length(); i++) {
            post = post * 10 + s.charAt(i) - '0';
        }

        if (post < 2) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
    }
}