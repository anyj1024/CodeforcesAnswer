package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] ss = br.readLine().split("W");
            getAns(ss);
        }
    }

    private static void getAns(String[] strings) {
        for (String s : strings) {
            int n = s.length();
            if (n == 0) continue;
            if (n <= 1) {
                System.out.println("NO");
                return;
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += s.charAt(i) == 'B' ? 1 : -1;
            }
            if (cnt == n || cnt == -n) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}