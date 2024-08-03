package Div4.CFRound898Div4;

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
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        char[] cs = br.readLine().toCharArray();

        int last = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if ((last == -1 || i - last + 1 > k) && cs[i] == 'B') {
                last = i;
                ans++;
            }
        }

        System.out.println(ans);
    }
}