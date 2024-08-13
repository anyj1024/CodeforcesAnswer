package Div1Div2.EPICRoundAugust2024Div1Div2;

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
        String[] nmk = br.readLine().split(" ");
        int n = Integer.parseInt(nmk[0]), m = Integer.parseInt(nmk[1]), k = Integer.parseInt(nmk[2]);

        int r = Math.min(n, k), c = Math.min(m, k);
        System.out.println(r * c);
    }
}