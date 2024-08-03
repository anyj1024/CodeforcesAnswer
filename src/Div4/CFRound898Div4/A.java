package Div4.CFRound898Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A   {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String s = br.readLine();
        if (s.charAt(0) == 'a' || s.charAt(1) == 'b' || s.charAt(2) == 'c') {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}