package Div4.CFRound928Div4;

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
        char[] cs = br.readLine().toCharArray();
        int count1 = 0, count2 = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'A') {
                count1++;
            } else {
                count2++;
            }
        }
        System.out.println(count1 > count2 ? "A" : "B");
    }
}

