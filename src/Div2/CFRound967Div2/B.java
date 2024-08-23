package Div2.CFRound967Div2;

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
        int n = Integer.parseInt(br.readLine());
        if ((n & 1) == 1) {
            for (int i = 1; i <= n; i++) {
                if ((i & 1) == 1) {
                    System.out.print(i + " ");
                }
            }
            for (int i = 1; i <= n; i++) {
                if ((i & 1) == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }
}