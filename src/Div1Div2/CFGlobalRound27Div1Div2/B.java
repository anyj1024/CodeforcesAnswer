package Div1Div2.CFGlobalRound27Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (n < 4 && (n & 1) == 1) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = n - 2;
        if ((count & 1) == 1) {
            for (int i = 0; i < count - 2; i++) {
                sb.append(3);
            }
            if (count - 2 > 0) {
                sb.append(63);
            }
        } else {
            for (int i = 0; i < count; i++) {
                sb.append(3);
            }
        }
        sb.append(66);
        System.out.println(sb);
    }
}
