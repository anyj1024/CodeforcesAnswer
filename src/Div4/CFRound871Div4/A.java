package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] proto = "codeforces".toCharArray();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[] cs = br.readLine().toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if (proto[i] != cs[i]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}