package Div2.CFRound926Div2;

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
        String[] kxa = br.readLine().split(" ");
        int k = Integer.parseInt(kxa[0]), x = Integer.parseInt(kxa[1]);
        long a = Long.parseLong(kxa[2]);

        long bet = 1, totalBet = 0;
        for (int i = 0; i <= x; i++) {
            if (totalBet + bet > a) {
                System.out.println("NO");
                return;
            }
            totalBet += bet;
            bet = totalBet / (k - 1) + 1;
        }
        System.out.println("YES");
    }
}