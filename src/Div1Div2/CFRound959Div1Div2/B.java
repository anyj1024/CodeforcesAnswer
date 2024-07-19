package Div1Div2.CFRound959Div1Div2;

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
        char[] s = br.readLine().toCharArray();
        char[] t = br.readLine().toCharArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == t[i] || s[i] == '1') {
                if (s[i] == '1') {
                    count++;
                }
                continue;
            }
            if (s[i] == '0' && count == 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}