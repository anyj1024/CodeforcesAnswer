package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);

        System.out.println(check(n, m) ? "YES" : "NO");
    }

    private static boolean check(int n, int m) {
        if (n == m) return true;
        if (n % 3 != 0 || n < m) {
            return false;
        }
        return check(n / 3 * 2, m) || check(n / 3, m);
    }
}