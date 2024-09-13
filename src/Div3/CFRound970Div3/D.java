package Div3.CFRound970Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] p;
    static boolean[] isBlack;
    static int[] parent;
    static int[] blackCount;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        p = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(input[i]) - 1;
        }
        char[] cs = br.readLine().toCharArray();

        isBlack = new boolean[n];
        for (int i = 0; i < n; i++) {
            isBlack[i] = (cs[i] == '0');
        }

        parent = new int[n];
        blackCount = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            blackCount[i] = isBlack[i] ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            union(i, p[i]);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = blackCount[find(i)];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            if (i < n - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            blackCount[rootY] += blackCount[rootX];
        }
    }
}