package Div1Div2.CodeTonRound7Div1Div2;

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
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ans = 0, count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') {
                count++;
            } else {
                ans += count;
                count = (count != 0 ? 1 : 0);
            }
        }
        System.out.println(ans);
    }
}