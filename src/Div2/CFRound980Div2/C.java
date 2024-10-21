package Div2.CFRound980Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
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
        int[][] pairs = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);
            pairs[i][0] = a;
            pairs[i][1] = b;
            pairs[i][2] = a + b;
        }

        Arrays.sort(pairs, (a, b) -> a[2] - b[2]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(pairs[i][0] + " " + pairs[i][1] + " ");
        }
        System.out.println(sb);
    }
}