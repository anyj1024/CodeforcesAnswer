package Div2.CFRound976Div2;

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
        long k = Long.parseLong(br.readLine());

        long sqrt = (long) Math.sqrt(k);
        if ((sqrt + 1) * (sqrt + 1) <= k + sqrt) sqrt++;
        System.out.println(k + sqrt);
    }
}