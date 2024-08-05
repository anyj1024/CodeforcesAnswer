package Div4.CFRound928Div4;

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
        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            int count = 0;
            for (char ch : line) {
                if (ch == '1') count++;
            }
            set.add(count);
        }

        System.out.println(set.size() > 2 ? "TRIANGLE" : "SQUARE");
    }
}
