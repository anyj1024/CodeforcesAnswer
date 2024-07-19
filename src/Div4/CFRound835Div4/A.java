package Div4.CFRound835Div4;

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

    public static void solve() throws IOException {
        String[] abc = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]), b = Integer.parseInt(abc[1]), c = Integer.parseInt(abc[2]);
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        if (a != min && a != max) {
            System.out.println(a);
        } else if (b != min && b != max) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }

}