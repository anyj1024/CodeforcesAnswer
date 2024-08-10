package Div3.CFRound486Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[] s = br.readLine().toCharArray();
        char[][] LAST = {{'0', '0'}, {'2', '5'}, {'5', '0'}, {'7', '5'}};

        int ans = Integer.MAX_VALUE;
        for (char[] t : LAST) {
            ans = Math.min(getCurrentAnswer(s, t[0], t[1]), ans);
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static int getCurrentAnswer(char[] s, char c1, char c2) {
        String str = new String(s);
        int p2 = str.lastIndexOf(c2);
        if (p2 == -1) return Integer.MAX_VALUE;
        str = str.substring(0, p2) + str.substring(p2 + 1);
        int p1 = str.lastIndexOf(c1);
        if (p1 == -1) return Integer.MAX_VALUE;
        int cnt = 0;
        while (cnt < str.length() && str.charAt(cnt) == '0') cnt++;
        return cnt + (s.length - 2) - p1 + (s.length - 1) - p2;
    }
}