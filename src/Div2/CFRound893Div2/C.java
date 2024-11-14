package Div2.CFRound893Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> ans = new ArrayList<>();
        ans.add(1);

        boolean[] visited = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            long d = i;
            while (d <= n) {
                if (visited[(int) d]) {
                    break;
                }
                ans.add((int) d);
                visited[(int) d] = true;
                d *= 2;
            }
        }

        for (int x : ans) System.out.print(x + " ");
        System.out.println();
    }
}