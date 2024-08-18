package Div2.EduRound169Div2;

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

    private static void solve() throws IOException {
        String[] l1r1 = br.readLine().split(" ");
        String[] l2r2 = br.readLine().split(" ");
        int l1 = Integer.parseInt(l1r1[0]), l2 = Integer.parseInt(l2r2[0]);
        int r1 = Integer.parseInt(l1r1[1]), r2 = Integer.parseInt(l2r2[1]);

        if (l1 > r2 || l2 > r1 || (l1 == l2 && r1 == r2 && r1 - 1 == l1)) {
            System.out.println(1);
        } else {
            int minL = Math.max(l1, l2), minR = Math.min(r1, r2);
            int ans = minR - minL + 2;
            if (l1 == l2) ans--;
            if (r1 == r2) ans--;
            System.out.println(ans);
        }
    }
}