package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            String[] ss = new String[n];
            for (int i = 0; i < n; i++) {
                ss[i] = br.readLine();
            }

            getAns(ss);
        }

    }

    private static void getAns(String[] ss) {
        int ans = Integer.MAX_VALUE;
        int n = ss.length, m = ss[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = ss[i], s2 = ss[j];
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += Math.abs(s1.charAt(k) - s2.charAt(k));
                }
                ans = Math.min(ans, sum);
            }
        }
        System.out.println(ans);
    }
}