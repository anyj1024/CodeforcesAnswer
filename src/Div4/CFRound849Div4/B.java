package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();
        int cnt1 = 0, cnt2 = 0;
        for (char ch : cs) {
            if (ch == 'U') cnt1++;
            else if (ch == 'D') cnt1--;
            else if (ch == 'L') cnt2--;
            else cnt2++;
            if (cnt1 == 1 && cnt2 == 1) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}