package Div2.EduRound154Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        char[] as = br.readLine().toCharArray(), bs = br.readLine().toCharArray();
        int n = as.length;
        for (int i = 1; i < n; i++) {
            if (as[i] == bs[i] && as[i - 1] == bs[i - 1] && as[i - 1] == '0' && as[i] == '1') {
                sb.append("YES\n");
                return;
            }
        }
        sb.append("NO\n");
    }
}
