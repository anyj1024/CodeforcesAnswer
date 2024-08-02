package Div4.CFRound886Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

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
        TreeSet<Integer> set = new TreeSet<>();
        int ans = 0, max = 0;
        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]);
            if (a <= 10) {
                if (max < b) {
                    max = b;
                    ans = i + 1;
                }
            }
        }
        System.out.println(ans);
    }
}