package Div3.CFRound494Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, d, k, cur;
    static List<Integer> x, y;
    static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] ndk = br.readLine().split(" ");
        n = Integer.parseInt(ndk[0]);
        d = Integer.parseInt(ndk[1]);
        k = Integer.parseInt(ndk[2]);
        x = new ArrayList<>();
        y = new ArrayList<>();

        cur = 1;
        if (cur < n) {
            x.add(1);
            y.add(cur + 1);
            dfs(cur++, 1);
        }

        if (cur < n || maxDepth < d) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < x.size(); i++) {
                System.out.println(x.get(i) + " " + y.get(i));
            }
        }
    }

    private static void dfs(int src, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (depth == d) return;
        for (int i = 0; cur < n && i < k - 1; i++) {
            depth = Math.max(depth, maxDepth - depth);
            if (depth + 1 <= d) {
                x.add(src + 1);
                y.add(cur + 1);
                dfs(cur++, depth + 1);
            }
        }
    }
}