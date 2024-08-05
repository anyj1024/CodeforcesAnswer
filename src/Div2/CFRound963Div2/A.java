package Div2.CFRound963Div2;

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

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'A') c1++;
            else if (cs[i] == 'B') c2++;
            else if (cs[i] == 'C') c3++;
            else if (cs[i] == 'D') c4++;
        }

        int ans = 0;
        ans += Math.min(c1, n);
        ans += Math.min(c2, n);
        ans += Math.min(c3, n);
        ans += Math.min(c4, n);

        System.out.println(ans);
    }
}

