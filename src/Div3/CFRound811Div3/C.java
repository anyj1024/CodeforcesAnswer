package Div3.CFRound811Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int cur = 9;
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            if (cur > n) {
                sb.append(n);
                break;
            } else {
                n -= cur;
                sb.append(cur);
                cur--;
            }
        }
        System.out.println(sb.reverse());
    }

}
