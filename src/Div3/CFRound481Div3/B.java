package Div3.CFRound481Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();

        int ans = 0, cnt = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'x') {
                cnt++;
            } else {
                ans += Math.max(cnt - 2, 0);
                cnt = 0;
            }
        }
        ans += Math.max(cnt - 2, 0);
        System.out.println(ans);
    }
}