package Div3.CFRound496Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[] cs1 = br.readLine().toCharArray(), cs2 = br.readLine().toCharArray();
        int n1 = cs1.length, n2 = cs2.length;

        int count = 0;
        int p1 = n1 - 1, p2 = n2 - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (cs1[p1] == cs2[p2]) {
                count++;
                p1--;
                p2--;
            } else {
                break;
            }
        }

        System.out.println(n1 + n2 - count * 2);
    }
}