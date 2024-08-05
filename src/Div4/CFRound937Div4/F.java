package Div4.CFRound937Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        String[] abc = br.readLine().split(" ");
        int a = Integer.parseInt(abc[0]), b = Integer.parseInt(abc[1]), c = Integer.parseInt(abc[2]);
        if (a + 1 != c) {
            System.out.println(-1);
            return;
        }

        if (a + b + c == 1) {
            System.out.println(0);
            return;
        }

        int cur = 1, ans = 1, next = 0;
        for (int i = 0; i < a + b; i++) {
            if (cur == 0) {
                cur = next;
                next = 0;
                ans++;
            }
            cur--;
            next++;
            if (i < a) next++;
        }

        System.out.println(ans);
    }
}