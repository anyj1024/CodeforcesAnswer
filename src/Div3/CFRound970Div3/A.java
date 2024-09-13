package Div3.CFRound970Div3;

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
        int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]);
        if (a % 2 == 1 || (b % 2 == 1 && a == 0)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}