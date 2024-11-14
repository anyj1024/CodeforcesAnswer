package Div3.CFRound900Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nkx = br.readLine().split(" ");
        int n = Integer.parseInt(nkx[0]), k = Integer.parseInt(nkx[1]);
        long x = Long.parseLong(nkx[2]);

        long maxSum = 1l * (n + n - k + 1) * k / 2, maxMin = 1l * (1 + k) * k / 2;
        if (maxSum < x || x < maxMin) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}