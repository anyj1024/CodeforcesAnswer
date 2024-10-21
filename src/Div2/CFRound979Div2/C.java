package Div2.CFRound979Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
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
        char[] cs = br.readLine().toCharArray();
        if (cs[0] == '1' || cs[n - 1] == '1') {
            System.out.println("YES");return;
        }

        for (int i = 1; i < cs.length; i++) {
            if (cs[i] == '1' && cs[i - 1] == '1') {
                System.out.println("YES");return;
            }
        }
        System.out.println("NO");
    }
}