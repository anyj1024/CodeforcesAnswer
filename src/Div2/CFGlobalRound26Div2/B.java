package Div2.CFGlobalRound26Div2;

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

    private static void solve() throws IOException {
        char[] cs = br.readLine().toCharArray();
        if (cs[0] != '1' || cs[cs.length - 1] == '9') {
            System.out.println("NO");
        } else {
            for (int i = 1; i < cs.length - 1; i++) {
                if (cs[i] == '0') {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }
}
