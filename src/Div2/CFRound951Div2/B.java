package Div2.CFRound951Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int x  = Integer.parseInt(s[0]), y = Integer.parseInt(s[1]);

            getAns(x, y);
        }
    }

    private static void getAns(int x, int y) {
        int n = x ^ y;
        for (int i = 0; i < 31; i++) {
            if (((1 << i) & n) != 0) {
                System.out.println((1 << i));
                return;
            }
        }
    }
}
