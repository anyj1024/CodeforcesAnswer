package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int left = 1, right = 999;
        while (right - left > 2) {
            int m1 = (left * 2 + right) / 3, m2 = (left + right * 2) / 3;
            System.out.println("? " + m1 + " " + m2);
            int res = Integer.parseInt(br.readLine());

            if (res == (m1 + 1) * (m2 + 1)) {
                right = m1;
            } else if (res == m1 * m2) {
                left = m2;
            } else {
                left = m1;
                right = m2;
            }
        }

        if (right - left == 2) {
            System.out.println("? 1 " + (left + 1));
            int res = Integer.parseInt(br.readLine());
            if (res == left + 1) {
                left = left + 1;
            } else {
                right = left + 1;
            }
        }
        System.out.println("! " + right);
    }

}