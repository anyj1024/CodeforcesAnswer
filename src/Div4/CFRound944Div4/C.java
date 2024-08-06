package Div4.CFRound944Div4;

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
        String[] abcd = br.readLine().split(" ");
        int a = Integer.parseInt(abcd[0]), b = Integer.parseInt(abcd[1]);
        int c = Integer.parseInt(abcd[2]), d = Integer.parseInt(abcd[3]);

        int x1 = Math.min(a, b), x2 = Math.max(a, b);
        int y1 = Math.min(c, d), y2 = Math.max(c, d);

        if ((y1 < x2 && y1 > x1 && !(y2 < x2 && y2 > x1)) || (y2 < x2 && y2 > x1 && !(y1 < x2 && y1 > x1))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

