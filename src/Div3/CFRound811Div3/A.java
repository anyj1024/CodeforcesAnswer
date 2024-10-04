package Div3.CFRound811Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nHM = br.readLine().split(" ");
        int n = Integer.parseInt(nHM[0]), H = Integer.parseInt(nHM[1]), M = Integer.parseInt(nHM[2]);
        int[] ans = new int[2];
        ans[0] = 24;
        ans[1] = 64;
        for (int i = 0; i < n; i++) {
            String[] hm = br.readLine().split(" ");
            int h = Integer.parseInt(hm[0]), m = Integer.parseInt(hm[1]);
            if (m < M) {
                m += 60;
                h--;
            }
            if (h < H) h += 24;

            if (ans[0] > h - H || (ans[0] == h - H && ans[1] > m - M)) {
                ans[0] = h - H;
                ans[1] = m - M;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

}