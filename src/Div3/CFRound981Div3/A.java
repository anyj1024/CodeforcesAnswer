package Div3.CFRound981Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cur = 0, f = -1, i = 1;
        while (Math.abs(cur) <= n) {
            cur += f * (2 * i - 1);
            i++;
            f = -f;
        }
        System.out.println(f == -1 ? "Kosuke" : "Sakurako");
    }
}