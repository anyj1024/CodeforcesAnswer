package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[] cs1 = br.readLine().toCharArray(), cs2 = br.readLine().toCharArray();
        int n1 = cs1.length, n2 = cs2.length;

        char[] ans = new char[n1];
        int p1 = n1 - 1, p2 = n2 - 1;
        while (p1 >= 0 && p2 >= 0) {
            char ch1 = cs1[p1], ch2 = cs2[p2];
            if (ch1 == ch2) {
                ans[p1] = ch1;
                p1--;
                p2--;
            } else if (ch1 != '?') {
                ans[p1] = ch1;
                p1--;
            } else if (ch1 == '?') {
                ans[p1] = ch2;
                p1--;
                p2--;
            }
        }
        if (p2 != -1) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i <= p1; i++) {
            if (cs1[i] == '?') {
                ans[i] = 'a';
            } else {
                ans[i] = cs1[i];
            }
        }
        System.out.println("YES");
        System.out.println(new String(ans));
    }
}