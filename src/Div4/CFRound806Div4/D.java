package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = br.readLine();
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(ss[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ss[i].length(); j++) {
                String left = ss[i].substring(0, j), right = ss[i].substring(j);
                if (set.contains(left) && set.contains(right)) {
                    sb.append(1);
                    break;
                }
            }
            if (sb.length() != i + 1) {
                sb.append(0);
            }
        }
        System.out.println(sb.toString());
    }
}