package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            char[] cs = br.readLine().toCharArray();

            getAns(cs);
        }

    }

    private static void getAns(char[] cs) {
        System.out.println(cs[0] + cs[1] + cs[2] == cs[3] + cs[4] + cs[5] ? "YES" : "NO");
    }
}