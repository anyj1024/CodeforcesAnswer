package Div3.CFRound962Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        System.out.println(countTriplets(n, k));
    }

    public static long countTriplets(int n, int x) {
        long count = 0;
        int maxB = Math.min(n, x - 2), maxA = Math.min((n - 1) / 2, x - 2);

        for (int b = 1; b <= maxB; b++) {
            int curB = Math.min(maxA, x - b - 1);
            if (curB < 1) break;

            for (int a = 1; a <= curB; a++) {
                int ab = a * b;
                int aplusb = a + b;
                int maxC = Math.min((n - ab) / aplusb, x - aplusb);
                if (maxC > 0) {
                    count += maxC;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}