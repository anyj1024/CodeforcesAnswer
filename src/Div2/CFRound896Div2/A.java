package Div2.CFRound896Div2;

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
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        if ((n & 1) == 0) {
            System.out.println(2);
            System.out.println(1 + " " + n);
            System.out.println(1 + " " + n);
        } else {
            System.out.println(4);
            System.out.println(1 + " " + n);
            System.out.println(1 + " " + 2);
            System.out.println(2 + " " + 3);
            System.out.println(2 + " " + n);
        }
    }
}
