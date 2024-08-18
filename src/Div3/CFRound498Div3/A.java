package Div3.CFRound498Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(input[i]);
            if (number % 2 == 0) {
                System.out.print((number - 1) + " ");
            } else {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}