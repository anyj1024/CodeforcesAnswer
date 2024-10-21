package Div3.CFRound697Div3;

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
        long n = Long.parseLong(br.readLine());
        while ((n & 1) == 0) {
            if ((n / 2) > 1 && ((n / 2) & 1) == 1) {
                System.out.println("YES");
                return;
            }
            n /= 2;
        }

        if (n > 1 && (n & 1) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}