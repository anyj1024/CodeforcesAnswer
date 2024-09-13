package Div3.CFRound521Div3;

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
        String[] abk = br.readLine().split(" ");
        long a = Long.parseLong(abk[0]), b = Long.parseLong(abk[1]), k = Long.parseLong(abk[2]);

        long delta = a - b, count = k / 2;
        long ans = delta * count + (k % 2 == 1 ? a : 0);
        System.out.println(ans);
    }
}