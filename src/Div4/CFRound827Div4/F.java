package Div4.CFRound827Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long n1 = 0, n2 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            String[] dkx = br.readLine().split(" ");
            int d = Integer.parseInt(dkx[0]), k = Integer.parseInt(dkx[1]);
            String x = dkx[2];

            if (d == 1) {
                n1 += 1l * x.length() * k;
                for (char ch : x.toCharArray()) {
                    if (ch != 'a') {
                        count1 = 1;
                    }
                }
            } else {
                n2 += 1l * x.length() * k;
                for (char ch : x.toCharArray()) {
                    if (ch != 'a') {
                        count2 = 1;
                    }
                }
            }

            if (count2 == 1) {
                System.out.println("YES");
            } else {
                if (n1 >= n2) {
                    System.out.println("NO");
                } else {
                    if (count1 == 0) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        }
    }

}