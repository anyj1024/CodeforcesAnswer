package Div4.CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]), c = Integer.parseInt(s[2]);

            getAns(a, b, c);
        }
    }

    private static void getAns(int a, int b, int c) {
        if (b == 0) {
            if (a != 0) {
                for (int i = 0; i <= a; i++) {
                    System.out.print(0);
                }
            } else {
                for (int i = 0; i <= c; i++) {
                    System.out.print(1);
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <= a; i++) {
            System.out.print(0);
        }
        for (int i = 0; i <= c; i++) {
            System.out.print(1);
        }
        for (int i = 0; i < b - 1; i++) {
            System.out.print(i % 2);
        }
        System.out.println();
    }
}