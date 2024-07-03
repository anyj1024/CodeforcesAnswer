package Div3.CFRound954Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int x2 = Integer.parseInt(s[1]);
            int x3 = Integer.parseInt(s[2]);

            getAns(x1, x2, x3);
        }
    }

    private static void getAns(int x1, int x2, int x3) {
        int ans = 300, cur = 0;
        for (int i = 1; i <= 10; i++) {
            cur = 0;
            cur += Math.abs(i - x1);
            cur += Math.abs(i - x2);
            cur += Math.abs(i - x3);
            ans = Math.min(ans, cur);
        }
        System.out.println(ans);
    }
}