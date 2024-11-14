package Div2.CFRound889Div2;

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

    public static void solve() throws IOException {
        long n = Long.parseLong(br.readLine());
        int cur = 1;
        while (n % cur == 0) {
            cur++;
        }
        System.out.println(cur - 1);
    }
}