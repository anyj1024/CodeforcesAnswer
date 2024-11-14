package Div2.CFRound986Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmv = br.readLine().split(" ");
        int n = Integer.parseInt(nmv[0]), m = Integer.parseInt(nmv[1]), v = Integer.parseInt(nmv[2]);
        String[] input = br.readLine().split(" ");
        long[] a = new long[n + 1];
        long[] f = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(input[i - 1]);
            f[i] = f[i - 1] + a[i];
        }

        int[] q = new int[m + 10];
        int[] h = new int[m + 10];
        q[0] = 0;
        int j = 0;

        for (int i = 1; i <= m; i++) {
            while (j <= n && f[j] - f[q[i - 1]] < v) {
                j++;
            }
            q[i] = j;
        }

        h[0] = n;
        j = n;

        for (int i = 1; i <= m; i++) {
            while (j >= 0 && f[h[i - 1]] - f[j] < v) {
                j--;
            }
            h[i] = j;
        }

        long ans = -1;
        for (int i = 0; i <= m; i++) {
            if (q[i] <= h[m - i]) {
                ans = Math.max(ans, f[h[m - i]] - f[q[i]]);
            }
        }

        System.out.println(ans);
    }
}