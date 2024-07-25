package Div2.CFRound961Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        if (k == 0) {
            System.out.println(0);
            return;
        }
        if (n >= k) {
            System.out.println(1);
            return;
        }
        int ans = 1, sum = n--;
        while (sum < k) {
            if (sum + n >= k) {
                System.out.println((ans + 1));
                return;
            }
            sum += 2 * (n--);
            ans += 2;
        }
        System.out.println(ans);
    }
}