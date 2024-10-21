package Div2.CFRound977Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nmq = br.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]), m = Integer.parseInt(nmq[1]), q = Integer.parseInt(nmq[2]);
        int[] a = new int[n], b = new int[m];
        String[] in1 = br.readLine().split(" "), in2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(in1[i]);
        for (int i = 0; i < m; i++) b[i] = Integer.parseInt(in2[i]);

        int cur = 0;
        boolean flag = true;
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            if (visited[b[i]]) continue;
            else if (b[i] == a[cur]) visited[a[cur++]] = true;
            else {
                System.out.println("TIDAK");
                return;
            }
        }
        System.out.println("YA");
    }

}
