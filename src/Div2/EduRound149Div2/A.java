package Div2.EduRound149Div2;

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
        String[] xk = br.readLine().split(" ");
        long x = Long.parseLong(xk[0]), k = Long.parseLong(xk[1]);

        if (x % k != 0) {
            System.out.println(1);
            System.out.println(x);
        } else {
            System.out.println(2);
            System.out.println(1 + " " + (x - 1));
        }
    }
}
