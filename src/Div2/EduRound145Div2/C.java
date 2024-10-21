package Div2.EduRound145Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);

        int x = 0;
        while (x * (x + 1) / 2 <= k) x++;
        if (x * (x + 1) / 2 > k) x--;
        int[] ans = new int[n + 1];
        k -= x * (x + 1) / 2;
        for (int i = 1; i <= n; i++) {
            if (i <= x) {
                ans[i] = 2;
            } else if (i == x + 1) {
                ans[i] = 2 * k - 2 * x - 1;
            } else {
                ans[i] = -1000;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
