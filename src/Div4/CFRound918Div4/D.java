package Div4.CFRound918Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D {
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
        Set<Character> V = new HashSet<>(Arrays.asList('a', 'e')), C = new HashSet<>(Arrays.asList('b', 'c', 'd'));

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0;) {
            if (C.contains(cs[i])) {
                sb.append(cs[i]);
                sb.append(cs[i - 1]);
                sb.append(cs[i - 2]);
                i -= 3;
            } else {
                sb.append(cs[i]);
                sb.append(cs[i - 1]);
                i -= 2;
            }

            sb.append('.');
        }

        sb.reverse();
        System.out.println(sb.substring(1));
    }
}

