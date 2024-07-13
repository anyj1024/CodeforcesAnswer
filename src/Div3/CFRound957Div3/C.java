package Div3.CFRound957Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        List<Integer> permutation = new ArrayList<>();

        for (int i = n; i >= k; i--) {
            permutation.add(i);
        }

        for (int i = k - 1; i > m; i--) {
            permutation.add(i);
        }

        for (int i = 1; i <= m; i++) {
            permutation.add(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(permutation.get(i));
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}