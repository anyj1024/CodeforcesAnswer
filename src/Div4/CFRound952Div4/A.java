package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");

            getAns(s[0], s[1]);
        }
    }

    private static void getAns(String s1, String s2) {
        char ch1 = s1.charAt(0), ch2 = s2.charAt(0);

        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        sb1.append(ch2);
        sb1.append(s1.substring(1));
        sb2.append(ch1);
        sb2.append(s2.substring(1));

        System.out.println(sb1.toString() + " " + sb2.toString());
    }
}
