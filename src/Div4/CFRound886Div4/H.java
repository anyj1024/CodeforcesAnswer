package Div4.CFRound886Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        DSUnionFind dsUnionFind = new DSUnionFind(n);
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            String[] uvw = br.readLine().split(" ");
            int u = Integer.parseInt(uvw[0]), v = Integer.parseInt(uvw[1]), w = Integer.parseInt(uvw[2]);
            if (dsUnionFind.find(u) != dsUnionFind.find(v)) {
                dsUnionFind.union(v, u, w);
            } else {
                if (dsUnionFind.distance[v] - dsUnionFind.distance[u] != w) {
                    flag = false;
                }
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static class DSUnionFind {
        int[] parent;
        long[] distance;
        int n;

        DSUnionFind(int n) {
            this.n = n;
            parent = new int[n + 1];
            distance = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                distance[i] = 0;
            }
        }

        public int find(int x) {
            if (x == parent[x]) return x;
            int root = find(parent[x]);
            distance[x] += distance[parent[x]];
            parent[x] = root;
            return parent[x];
        }

        public void union(int x, int y, int w) {
            int fx = find(x), fy = find(y);
            if (fx != fy) {
                parent[fx] = fy;
                distance[fx] += distance[y] - distance[x] + w;
            }
        }
    }
}