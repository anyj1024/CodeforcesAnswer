package Div3.CFRound863Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), d = Integer.parseInt(s[1]);
            String s1 = br.readLine();

            getAns(d, s1);
        }

    }

    private static void getAns(int d, String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0, n = s.length(), cnt = 0;
        while (index < n) {
            if (cnt == 0 && s.charAt(index) < (d + '0')) {
                sb.append(d);
                cnt++;
                continue;
            }
            sb.append(s.charAt(index));
            index++;
        }
        if (cnt == 0) sb.append(d);
        System.out.println(sb.toString());
    }
}