package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]), d = Integer.parseInt(s[3]);

        int ans = 0;

        if ((a > c && b >= d) || (a >= c && b > d)) ans++;
        if ((a > d && b >= c) || (a >= d && b > c)) ans++;

        System.out.println(ans * 2);
    }
}