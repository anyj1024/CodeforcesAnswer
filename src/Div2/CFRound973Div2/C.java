package Div2.CFRound973Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = "";

        boolean isEnd = false;
        while (s.length() < n) {
            if (!isEnd && query("0" + s)) {
                s = "0" + s;
            } else if (!isEnd && query("1" + s)) {
                s = "1" + s;
            } else {
                if (query(s + "0")) {
                    s = s + "0";
                } else {
                    s = s + "1";
                }
                isEnd = true;
            }
        }

        System.out.println("! " + s);
    }

    private static boolean query(String s) throws IOException {
        System.out.println("? " + s);
        System.out.flush();
        return Integer.parseInt(br.readLine()) == 1;
    }

}