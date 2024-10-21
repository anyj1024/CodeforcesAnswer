package Div2.EduRound170Div2;

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

    private static void solve() throws IOException {
        char[] cs1 = br.readLine().toCharArray(), cs2 = br.readLine().toCharArray();
        int count = 0, p1 = 0, p2 = 0;
        while (p1 < cs1.length && p2 < cs2.length && cs1[p1] == cs2[p2]) {
            count++;
            p1++;
            p2++;
        }

        System.out.println(count == 0 ? cs1.length + cs2.length : count + 1 + (cs1.length - count) + (cs2.length - count));
    }
}
