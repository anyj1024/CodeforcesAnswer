package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class A {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> set = new HashSet<>(Arrays.asList("YES", "YEs", "YeS", "yES", "yeS", "yEs", "Yes", "yes"));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String s = br.readLine();
        if (set.contains(s)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}