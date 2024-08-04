package Div4.CFRound918Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        int[] cnt = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == '?') continue;
                cnt[grid[i][j] - 'A']++;
            }
        }

        if (cnt[0] == 2) {
            System.out.println("A");
        } else if (cnt[1] == 2) {
            System.out.println("B");
        } else if (cnt[2] == 2) {
            System.out.println("C");
        }
    }
}
