package Div4.CFRound835Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();

        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            ans = Math.max(ans, cs[i] - 'a' + 1);
        }

        System.out.println(ans);
    }

}