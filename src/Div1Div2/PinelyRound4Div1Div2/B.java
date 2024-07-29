package Div1Div2.PinelyRound4Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] ns = br.readLine().split(" ");
        int[] b = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            b[i] = Integer.parseInt(ns[i]);
        }

        int[] a = new int[n];
        a[0] = b[0];
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                a[i] = b[i - 1];
            } else {
                a[i] = b[i - 1] | b[i];
            }
            if ((a[i - 1] & a[i]) != b[i - 1]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

}