package Div3.CFRound506Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, - 1}};
    static int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        int cnt = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (s.substring(0, i).equals(s.substring(n - i, n))) {
                cnt = i;
                break;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            sb.append(s.substring(cnt));
        }
        System.out.println(sb);
    }
}