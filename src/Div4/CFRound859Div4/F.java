package Div4.CFRound859Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, int[]> dirs = new HashMap<>();
    static {
        dirs.put("DR", new int[]{1, 1});
        dirs.put("DL", new int[]{1, -1});
        dirs.put("UR", new int[]{-1, 1});
        dirs.put("UL", new int[]{-1, -1});
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmi1j1i2j2d = br.readLine().split(" ");
        int n = Integer.parseInt(nmi1j1i2j2d[0]), m = Integer.parseInt(nmi1j1i2j2d[1]);
        int i1 = Integer.parseInt(nmi1j1i2j2d[2]), j1 = Integer.parseInt(nmi1j1i2j2d[3]);
        int i2 = Integer.parseInt(nmi1j1i2j2d[4]), j2 = Integer.parseInt(nmi1j1i2j2d[5]);
        String d = nmi1j1i2j2d[6];

        Set<String> set = new HashSet<>();
        boolean f = true;
        int step = 0;
        while (true) {
//            System.out.println((i1 + "|" + j1 + "   " + d + "  "));
            if (set.contains(i1 + "|" + j1 + d)) {
                f = false;
                break;
            }
//            step++;
            set.add(i1 + "|" + j1 + d);
            if (i1 == i2 && j1 == j2) break;
            if ((i1 == n && d.charAt(0) == 'D')
                    || (i1 == 1 && d.charAt(0) == 'U')
                    || (j1 == m && d.charAt(1) == 'R')
                    || (j1 == 1 && d.charAt(1) == 'L')) {
//                System.out.println(" transfer  " + i1 + " " + j1 + "  " + d + "  " + n + "  "+ m);
                step++;
                if ((i1 == 1 && j1 == 1 && !d.equals("DR")) || (i1 == n && j1 == 1 && !d.equals("UR"))
                        || (i1 == 1 && j1 == m && !d.equals("DL")) || (i1 == n && j1 == m && !d.equals("UL"))) {
                    if (i1 == 1 && j1 == 1) d = "DR";
                    else if (i1 == n && j1 == 1) d = "UR";
                    else if (i1 == 1 && j1 == m) d = "DL";
                    else if (i1 == n && j1 == m) d = "UL";
                } else {
                    if (i1 == 1 || i1 == n) d = (d.charAt(0) == 'D' ? "U" : "D") + d.substring(1);
                    else if (j1 == 1 || j1 == m) d = d.substring(0, 1) + (d.charAt(1) == 'L' ? "R" : "L");
                }
//                System.out.println(" transfer  " + i1 + " " + j1 + "  " + d);
                continue;
            }
            int[] dir = dirs.get(d);
            i1 += dir[0];
            j1 += dir[1];
        }
        System.out.println(f ? step : -1);
    }
}