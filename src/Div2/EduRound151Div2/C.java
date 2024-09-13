package Div2.EduRound151Div2;

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

    private static void solve() throws IOException {
        char[] s = br.readLine().toCharArray();
        int n = s.length;
        int m = Integer.parseInt(br.readLine());
        String l = br.readLine();
        String r = br.readLine();

        int mx = 0;
        for (int i = 0; i < m; i++) {
            int li = l.charAt(i) - '0';
            int ri = r.charAt(i) - '0';
            int nmx = mx;

            for (int c = li; c <= ri; c++) {
                int cur = mx;
                while (cur < n && s[cur] - '0' != c) {
                    cur++;
                }
                nmx = Math.max(nmx, cur);
            }
            mx = nmx + 1;
        }

        System.out.println(mx > n ? "YES" : "NO");
    }
}