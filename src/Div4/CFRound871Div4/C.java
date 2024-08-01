package Div4.CFRound871Div4;

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
        int n = Integer.parseInt(br.readLine());

        int ans = 1000001;
        int a = 1000001, b = 1000001;
        for (int i = 0; i < n; i++) {
            String[] m = br.readLine().split(" ");
            int cost = Integer.parseInt(m[0]);
            String type = m[1];
            if (type.equals("00")) continue;
            if (type.equals("11")) {
                ans = Math.min(ans, cost);
            }
            if (type.charAt(0) == '1') a = Math.min(a, cost);
            if (type.charAt(1) == '1') b = Math.min(b, cost);
        }
        ans = Math.min(ans, a + b);
        System.out.println(ans >= 1000000 ? -1 : ans);
    }
}