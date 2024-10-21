package Div2.CFRound914Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] ab = br.readLine().split(" "), xyk = br.readLine().split(" "), xyq = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]), xk = Integer.parseInt(xyk[0]), yk = Integer.parseInt(xyk[1]);
        int xq = Integer.parseInt(xyq[0]), yq = Integer.parseInt(xyq[1]);

        int[][] dirs = {{a, b}, {a, -b}, {-a, b}, {-a, -b}, {b, a}, {b, -a}, {-b, a}, {-b, -a}};
        Set<String> set = new HashSet<>();
        int ans = 0;
        for (int[] dir : dirs) {
            set.add((xk + dir[0]) + "|" + (yk + dir[1]));
        }
        for (int[] dir : dirs) {
            if (set.contains((xq + dir[0]) + "|" + (yq + dir[1]))) {
                ans++;
            }
        }
        System.out.println(a == b ? ans / 2 : ans);
    }
}