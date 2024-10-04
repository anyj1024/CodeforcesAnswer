package Div2.CFRound969Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    private static void solve() throws IOException {
        String[] lr = br.readLine().split(" ");
        int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
        if ((l & 1) == 0) l++;

        int ans = 0, count = 0;
        for (int i = l; i <= r; i++) {
            if ((i & 1) == 1) {
                count++;
            }
            if (count == 2) {
                ans++;
                count = 0;
            }
        }

        System.out.println(ans);
    }
}