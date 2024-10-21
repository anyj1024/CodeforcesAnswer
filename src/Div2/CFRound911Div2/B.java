package Div2.CFRound911Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] abc = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]) % 2, b = Integer.parseInt(abc[1]) % 2, c = Integer.parseInt(abc[2]) % 2;
        if (a == b && b == c) {
            System.out.println("1 1 1");
        } else if (a == b) {
            System.out.println("0 0 1");
        } else if (a == c) {
            System.out.println("0 1 0");
        } else if (b == c) {
            System.out.println("1 0 0");
        }

    }
}