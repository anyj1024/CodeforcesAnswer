package Div2.EduRound168Div2;

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
        char[] cs = br.readLine().toCharArray();
        int n = cs.length;

        boolean insert = false;
        StringBuilder sb = new StringBuilder();
        sb.append(cs[0]);
        for (int i = 1; i < n; i++) {
            if (cs[i] == cs[i - 1] && !insert) {
                sb.append((char) ((26 - 'a' + cs[i] + 1) % 26 + 'a'));
                insert = true;
            }
            sb.append(cs[i]);
        }
        if (!insert) sb.append((char) ((26 - 'a' + cs[n - 1] + 1) % 26 + 'a'));
        System.out.println(sb.toString());
    }
}