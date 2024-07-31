package Div4.CFRound859Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
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
        int[] lastPosition = new int[26];
        Arrays.fill(lastPosition, -1);
        boolean f = true;

        for (int i = 0; i < n; i++) {
            char ch = cs[i];
            if (lastPosition[ch - 'a'] == -1) {
                lastPosition[ch - 'a'] = i;
            } else {
                if (lastPosition[ch - 'a'] % 2 != i % 2) {
                    f = false;
                    break;
                }
            }
        }

        System.out.println(f ? "YES" : "NO");
    }
}