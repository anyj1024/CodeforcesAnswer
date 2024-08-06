package Div4.CFRound944Div4;

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
        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]);
        System.out.println(Math.min(a, b) + " " + Math.max(a, b));
    }
}

