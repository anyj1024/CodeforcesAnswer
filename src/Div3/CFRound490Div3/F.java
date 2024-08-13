package Div3.CFRound490Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        int[] h = new int[k + 1];
        int[] peoples = new int[100001], cards = new int[100001];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n * k; i++) {
            int card = Integer.parseInt(input[i - 1]);
            cards[card]++;
        }
        String[] input1 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            int favoriteCard = Integer.parseInt(input1[i - 1]);
            peoples[favoriteCard]++;
        }
        String[] input2 = br.readLine().split(" ");
        for (int i = 1; i <= k; i++) {
            h[i] = Integer.parseInt(input2[i - 1]);
        }

        long[][] dp = new long[5001][5001];
        long ans = 0;
        for (int l = 1; l <= 100000; l++) {
            if (cards[l] == 0 || peoples[l] == 0) continue;
            for (int i = 1; i <= peoples[l]; i++) {
                for (int j = 1; j <= cards[l]; j++) {
                    for (int m = 0; m <= Math.min(j, k); m++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - m] + h[m]);
                    }
                }
            }
            ans += dp[peoples[l]][cards[l]];
        }

        System.out.println(ans);
    }
}