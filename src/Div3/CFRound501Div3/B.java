package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] s1 = br.readLine().toCharArray(), s2 = br.readLine().toCharArray();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = 0;
            for (int j = i; j < n; j++) {
                if (s2[i] == s1[j]) {
                    d = 1;
                    for (int k = j; k > i; k--) {
                        ans.add(k);
                        char temp = s1[k];
                        s1[k] = s1[k - 1];
                        s1[k - 1] = temp;
                    }
                    break;
                }
            }
            if (d == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}