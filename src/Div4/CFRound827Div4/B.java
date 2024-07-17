package Div4.CFRound827Div4;

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

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(s[i])) {
                System.out.println("NO");
                return;
            }
            set.add(s[i]);
        }
        System.out.println("YES");
    }
}