package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmk = br.readLine().split(" ");
        long n = Long.parseLong(nmk[0]), k = Long.parseLong(nmk[1]), s = Long.parseLong(nmk[2]);

        long cur = 1;
        // a + b * (n - 1) = k;
        long b = s / (n - 1), a = s - b * (n - 1);
        if (b > k || (b == k && a > 0) || k > s) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        while (s > k - 1 + n - 1) {
            if (s <= n - 1 && k > 1) break;
            long step = Math.min(n - 1, s);
            if (cur == 1) {
                System.out.print((1 + step) + " ");
                cur = 1 + step;
            } else {
                System.out.print((cur - step) + " ");
                cur = cur - step;
            }
            s -= step;
            k--;
        }
        long delta = s - (k - 1);
        if (k > 0 && cur == 1) {
            System.out.print((1 + delta) + " ");
            cur = 1 + delta;
        } else if (k > 0) {
            System.out.print((cur - delta) + " ");
            cur = cur - delta;
        }
        k--;
        if (k <= 0) return;
        while (k-- != 0) {
            if (cur <= n - 1) {
                System.out.print((cur + 1) + " ");
                cur++;
            } else {
                System.out.print((cur - 1) + " ");
                cur--;
            }
        }
        System.out.println();
    }

}