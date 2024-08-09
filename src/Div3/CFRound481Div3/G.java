package Div3.CFRound481Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[][] exams = new int[m][4];
        int[] ans = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] sdc = br.readLine().split(" ");
            int s = Integer.parseInt(sdc[0]), d = Integer.parseInt(sdc[1]), c = Integer.parseInt(sdc[2]);
            exams[i][0] = s;
            exams[i][1] = d;
            exams[i][2] = c;
            exams[i][3] = i + 1;
        }

        Arrays.sort(exams, (a, b) -> a[1] != b[1] ? (a[1] - b[1]) : (a[0] - b[0]));
        for (int i = 0; i < exams.length; i++) {
            int[] cur = exams[i];
            int start = cur[0], end = cur[1], cost = cur[2], index = cur[3];

            int count = 0;
            for (int j = start; j < end && count != cost; j++) {
                if (ans[j] != 0) continue;
                ans[j] = index;
                count++;
            }
            ans[end] = m + 1;

            if (count != cost) {
                System.out.println(-1);
                return;
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i + 1] + " ");
        }
        System.out.println();
    }
}