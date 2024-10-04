package Div3.CFRound974Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        long n = Long.parseLong(nk[0]), k = Long.parseLong(nk[1]);

        long right = n, left = Math.max(1, n - k + 1);
        long count = right - left + 1;

        if ((count == 1 && (right & 1) == 0) || (count > 2 && (count & 1) != 0 && (((right & 1) == 0 && ((count / 2) & 1) == 0) || ((right & 1) != 0 && ((count / 2 + 1) & 1) == 0))) || count % 4 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}