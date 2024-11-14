package Div2.EduRound155Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
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
        String[] ain = br.readLine().split(" "), bin = br.readLine().split(" ");
        int[] as  = new int[n], bs = new int[n];
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;
        long sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            as[i] = Integer.parseInt(ain[i]);
            minA = Math.min(minA, as[i]);
            sumA += as[i];
            bs[i] = Integer.parseInt(bin[i]);
            minB = Math.min(minB, bs[i]);
            sumB += bs[i];
        }

        System.out.println(Math.min(sumA + 1l * n * minB, sumB + 1l * n * minA));
    }
}