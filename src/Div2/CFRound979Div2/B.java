package Div2.CFRound979Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            sb.append('0');
        } else {
            for (int i = 0; i < n - 1; i++) {
                sb.append('0');
            }
            sb.append('1');
        }
        System.out.println(sb.toString());
    }
}