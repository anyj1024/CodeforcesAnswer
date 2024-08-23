package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        boolean[] visited = new boolean[m + 1];
        int count = m;
        for (int i = 0; i < n; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
            for (int j = l; j <= r; j++) {
                if (visited[j]) continue;
                visited[j] = true;
                count--;
            }
        }

        System.out.println(count);
        for (int i = 1; i <= m; i++) {
            if (!visited[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}