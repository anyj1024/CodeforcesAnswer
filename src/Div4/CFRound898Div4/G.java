package Div4.CFRound898Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[] cs = br.readLine().toCharArray();
        int n = cs.length;

        int sum = 0, min = n, cur = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'A') {
                cur++;
                sum++;
            } else {
                min = Math.min(min, cur);
                cur = 0;
            }
        }
        if (cs[n - 1] == 'A') min = Math.min(min, cur);

//        System.out.println(sum + " " + min);
        if (cs[0] == 'A' && cs[n - 1] == 'A') {
            System.out.println(sum - min);
        } else {
            System.out.println(sum);
        }
    }
}