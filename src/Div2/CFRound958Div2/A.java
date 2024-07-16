package Div2.CFRound958Div2;

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
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);

        int ans = 0;
        while (n != 1) {
            if (n > k) {
                ans++;
                n -= k - 1;
            } else {
                ans++;
                n = 1;
            }
        }

        System.out.println(ans);
    }
}