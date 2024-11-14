package Div1Div2.CFGlobalRound27Div1Div2;

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

    public static void solve() throws IOException {
        String[] nmrc = br.readLine().split(" ");
        long n = Long.parseLong(nmrc[0]), m = Long.parseLong(nmrc[1]);
        long r = Long.parseLong(nmrc[2]), c = Long.parseLong(nmrc[3]);

        long i = (r - 1) * m + c, sum = n * m;
        long t = sum - i;

        if (t == 0) {
            System.out.println(0);
            return;
        }

        long s = i, e = sum - 1;

        long Nm = (e / m) - ((s - 1) / m);
        long ans = Nm * m + (t - Nm) * 1;

        System.out.println(ans);
    }
}
