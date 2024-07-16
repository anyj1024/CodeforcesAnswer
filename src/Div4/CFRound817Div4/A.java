package Div4.CFRound817Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] cs1 = {'T', 'i', 'm', 'u', 'r'};

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();
        Arrays.sort(cs);
        Arrays.sort(cs1);
        if (cs.length != 5) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cs1[i] != cs[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}