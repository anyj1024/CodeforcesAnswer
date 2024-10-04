package Div2.CFRound976Div2;

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
        String[] nk = br.readLine().split(" ");
        long n = Long.parseLong(nk[0]), k = Long.parseLong(nk[1]);
        if (k == 1) {
            System.out.println(n);
            return;
        }

        long ans = 0;
        while (n > 0) {
            ans += n % k;
            n /= k;
        }
        System.out.println(ans);
    }
}