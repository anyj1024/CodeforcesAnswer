package Div4.CFRound937Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] dp = new boolean[100000 + 1];

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        dp[1] = true;
        for (int i = 1; i <= 100000; i++) {
            if (!isRightNumber(i)) continue;
            for (int j = 1; i * j <= 100000; j++) {
                if (dp[j]) {
                    dp[i * j] = true;
                }
            }
        }

        while (t-- > 0) {
            solve();
        }
    }



    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        if (dp[n]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isRightNumber(int number) {
        while (number != 0) {
            if (number % 10 != 0 && number % 10 != 1) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
