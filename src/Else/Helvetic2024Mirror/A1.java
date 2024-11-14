package Else.Helvetic2024Mirror;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        String str = br.readLine();
        int n = str.length();
        int[][] balance = new int[n][2];
        int flow = 0;
        for (int i = 1; i < n; i++) {
            balance[i][0] = i;
            if (str.charAt(i - 1) == '(') flow++;
            else flow--;
            balance[i][1] = flow;
        }

        Arrays.sort(balance, (a, b) -> (a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]));

        for (int i = 0; i < n; i++) {
            int idx = balance[i][0];
            sb.append(str.charAt(idx));
        }

        sb.append("\n");
    }
}