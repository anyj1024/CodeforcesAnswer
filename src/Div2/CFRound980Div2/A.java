package Div2.CFRound980Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String[] ab = br.readLine().split(" ");
        long a = Long.parseLong(ab[0]), b = Long.parseLong(ab[1]);

        long min = Math.max(0, b - a), max = Math.min(a, b / 2);
        if (min > max) {
            System.out.println(0);
        } else {
            System.out.println(a - min);
        }
    }
}