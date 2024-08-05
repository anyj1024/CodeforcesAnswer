package Div4.CFRound937Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] abc = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]), b = Integer.parseInt(abc[1]), c = Integer.parseInt(abc[2]);
        if (a < b && b < c) {
            System.out.println("STAIR");
        } else if (a < b && b > c) {
            System.out.println("PEAK");
        } else {
            System.out.println("NONE");
        }
    }
}
