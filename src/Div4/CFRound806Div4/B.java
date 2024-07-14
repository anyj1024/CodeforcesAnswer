package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();

        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (char ch : cs) {
            if (set.contains(ch)) {
                ans += 1;
            } else {
                ans += 2;
                set.add(ch);
            }
        }
        System.out.println(ans);
    }
}