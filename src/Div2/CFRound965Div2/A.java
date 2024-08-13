package Div2.CFRound965Div2;

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
        String[] xyk = br.readLine().split(" ");
        int x = Integer.parseInt(xyk[0]), y = Integer.parseInt(xyk[1]), k = Integer.parseInt(xyk[2]);
        if ((k & 1) == 1) {
            System.out.println(x + " " + y);
            k--;
        }

        for (int i = 1; i <= k / 2; i++) {
            System.out.println((x + i) + " " + (y + i));
            System.out.println((x - i) + " " + (y - i));
        }
    }
}