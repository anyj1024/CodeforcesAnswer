package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve(br);
        }
    }

    private static void solve(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        System.out.println(n / 10 + (n % 10));
    }
}