package Div3.CFRound962Div3;

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

    public static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        char[] as = br.readLine().toCharArray();
        char[] bs = br.readLine().toCharArray();

        int[][] preSumA = new int[n + 1][26], preSumB = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            System.arraycopy(preSumA[i - 1], 0, preSumA[i], 0, 26);
            System.arraycopy(preSumB[i - 1], 0, preSumB[i], 0, 26);

            preSumA[i][as[i - 1] - 'a']++;
            preSumB[i][bs[i - 1] - 'a']++;
        }

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int l = Integer.parseInt(query[0]), r = Integer.parseInt(query[1]);
            int[] diff = getIntervalDifference(preSumA, preSumB, l - 1, r);
            int positive = 0, negative = 0;

            for (int count : diff) {
                if (count > 0) {
                    positive += count;
                } else {
                    negative -= count;
                }
            }

            System.out.println(Math.max(positive, negative));
        }
    }

    public static int[] getIntervalDifference(int[][] preSumA, int[][] preSumB, int l, int r) {
        int[] diff = new int[26];
        for (int i = 0; i < 26; i++) {
            int countA = preSumA[r][i] - preSumA[l][i];
            int countB = preSumB[r][i] - preSumB[l][i];
            diff[i] = countA - countB;
        }
        return diff;
    }
}