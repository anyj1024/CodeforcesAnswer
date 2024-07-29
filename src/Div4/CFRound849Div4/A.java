package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Character> set = new HashSet<>(Arrays.asList('c', 'o', 'd', 'e', 'f', 'r', 's'));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        char ch = br.readLine().charAt(0);
        if (set.contains(ch)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}