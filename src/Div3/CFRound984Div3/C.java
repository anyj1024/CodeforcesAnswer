package Div3.CFRound984Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        char[] s = br.readLine().toCharArray();
        int n = s.length;
        Set<Integer> pos = new HashSet<>();
        for (int j = 0; j <= n - 4; j++) {
            if (new String(s, j, 4).equals("1100")) {
                pos.add(j);
            }
        }
        int q = Integer.parseInt(br.readLine());
        for (int query = 0; query < q; query++) {
            String[] line = br.readLine().split(" ");
            int i = Integer.parseInt(line[0]) - 1;
            char v = line[1].charAt(0);
            s[i] = v;

            for (int j = i - 3; j <= i; j++) {
                if (j >= 0 && j <= n - 4) {
                    String sub = new String(s, j, 4);
                    if (sub.equals("1100")) {
                        pos.add(j);
                    } else {
                        pos.remove(j);
                    }
                }
            }

            sb.append(!pos.isEmpty() ? "YES" : "NO").append("\n");
        }
    }
}
