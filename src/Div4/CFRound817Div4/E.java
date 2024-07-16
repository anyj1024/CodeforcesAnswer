package Div4.CFRound817Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        long[][] preSum = new long[1001][1001];
        long[][] board = new long[1001][1001];
        for (int i = 0; i < n; i++) {
            String[] hw = br.readLine().split(" ");
            int h = Integer.parseInt(hw[0]), w = Integer.parseInt(hw[1]);
            board[h][w] += h * w;
        }

        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + board[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            String[] hwhw = br.readLine().split(" ");
            int hs = Integer.parseInt(hwhw[0]), ws = Integer.parseInt(hwhw[1]);
            int hb = Integer.parseInt(hwhw[2]), wb = Integer.parseInt(hwhw[3]);

            System.out.println(preSum[hb - 1][wb - 1] - preSum[hb - 1][ws] - preSum[hs][wb - 1] + preSum[hs][ws]);
        }
    }

}