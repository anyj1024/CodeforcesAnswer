package Div2.CFRound968Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A {
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

        boolean found = s.charAt(0) != s.charAt(n - 1);

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}