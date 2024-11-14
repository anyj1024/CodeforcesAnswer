package Div2.EduRound153Div2;

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
        String s = br.readLine();
        int n = s.length();
        if (s.equals("()")) {
            System.out.println("NO");
            return;
        }
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append("()");
            sb2.append("(");
        }
        for (int i = 0; i < n; i++) {
            sb2.append(")");
        }
        String s1 = sb1.toString(), s2 = sb2.toString();
        System.out.println("YES");
        if (s1.contains(s)) {
            System.out.println(s2);
        } else {
            System.out.println(s1);
        }
    }
}