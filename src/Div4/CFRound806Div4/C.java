package Div4.CFRound806Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(s1[i]);
            String[] s = br.readLine().split(" ");
            int count = Integer.parseInt(s[0]);
            char[] cs = s[1].toCharArray();

            for (int j = 0; j < count; j++) {
                if (cs[j] == 'U') {
                    if (number > 0) number--;
                    else number = 9;
                } else {
                    if (number < 9) number++;
                    else number = 0;
                }
            }

            System.out.print(number + " ");
        }
        System.out.println();
    }
}