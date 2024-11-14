package Div2.CFRound986Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nab = br.readLine().split(" ");
        int n = Integer.parseInt(nab[0]), a = Integer.parseInt(nab[1]), b = Integer.parseInt(nab[2]);
        char[] cs = br.readLine().toCharArray();
        int x = 0, y = 0;
        for (int i = 1; i <= 100; i++) {
            for (char ch : cs) {
                if (ch == 'N') {
                    y++;
                } else if (ch == 'E') {
                    x++;
                } else if (ch == 'S') {
                    y--;
                } else {
                    x--;
                }
                if (x == a && y == b) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }

}
