package Div2.CFRound972Div2;

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
        int k = n % 5;
        n /= 5;
        char[] chs = {'a', 'e', 'i', 'o', 'u'};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(chs[i]);
            }
            if (i < k) sb.append(chs[i]);
        }

        System.out.println(sb);
    }
}