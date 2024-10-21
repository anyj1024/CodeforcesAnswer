package Else.CFBetaRound77;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String s = br.readLine();
        int cur = 1, curChar = s.charAt(0) - '0';
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - '0' == curChar) {
                cur++;
            } else {
                max = Math.max(max, cur);
                curChar = s.charAt(i) - '0';
                cur = 1;
            }
        }
        max = Math.max(max, cur);
        System.out.println(max >= 7 ? "YES" : "NO");
    }
}