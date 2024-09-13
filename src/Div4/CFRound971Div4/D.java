package Div4.CFRound971Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D {
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
        Set<Integer>[] set = new Set[2];
        set[0] = new HashSet<>();
        set[1] = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            set[y].add(x);
        }

        long ans = 0;
        for (int x : set[0]) {
            if (set[1].contains(x)) {
                ans += n - 2;
            }
        }
        for (int x : set[0]) {
            if (set[1].contains(x - 1) && set[1].contains(x + 1)) ans++;
        }
        for (int x : set[1]) {
            if (set[0].contains(x - 1) && set[0].contains(x + 1)) ans++;
        }

        System.out.println(ans);
    }
}