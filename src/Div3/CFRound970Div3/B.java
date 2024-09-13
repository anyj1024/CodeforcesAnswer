package Div3.CFRound970Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n) {
            System.out.println("NO");
            return;
        }

        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < sqrt; i++) {
            sb1.append(1);
            if (i == 0 || i == sqrt - 1) {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        }
//        System.out.println("s1 " + sb1 + "  sb2 " + sb2);
        for (int i = 0; i <= n - sqrt; i += sqrt) {
            String subString = s.substring(i, i + sqrt);
//            System.out.println("s1 " + sb1 + "  sb2 " + sb2 + "    " + subString);

            if (i == 0 || i == n - sqrt) {
                if (!subString.equals(sb1.toString())) {
                    System.out.println("NO");
                    return;
                }
            } else {
                if (!subString.equals(sb2.toString())) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }
}