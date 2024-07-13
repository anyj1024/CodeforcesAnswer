package Div3.CFRound957Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);
        char[] cs1 = br.readLine().toCharArray();
        char[] cs = new char[n + 2];
        cs[0] = cs[n + 1] = 'L';
        for (int i = 1; i <= n; i++) {
            cs[i] = cs1[i - 1];
        }

        boolean[] canReach = new boolean[n + 2];
        int[] waterCount = new int[n + 2];
        Arrays.fill(waterCount, Integer.MAX_VALUE);
        waterCount[0] = 0;
        canReach[0] = true;

        for (int i = 0; i <= n + 1; i++) {
            if (!canReach[i] || cs[i] == 'C') continue;
            if (cs[i] == 'L') {
                for (int j = 1; j <= m; j++) {
                    if (i + j > n + 1) break;
                    int lastCount = waterCount[i];
                    waterCount[i + j] = Math.min(waterCount[i + j], lastCount);
                    if (cs[i + j] == 'W') {
                        waterCount[i + j]++;
                    }
                }
                for (int j = 1; j <= m; j++) {
                    if (i + j > n + 1) break;
                    if (waterCount[i + j] <= k) {
                        canReach[i + j] = true;
                    }
                    if (cs[i + j] == 'C') {
                        canReach[i + j] = false;
                    }
                }
            } else if (cs[i] == 'W') {
                int lastCount = waterCount[i] + (cs[i + 1] == 'W' ? 1 : 0);
                waterCount[i + 1] = Math.min(waterCount[i + 1], lastCount);
                if (waterCount[i + 1] <= k && cs[i + 1] != 'C') {
                    canReach[i + 1] = true;
                }
            }
        }
//        System.out.println(Arrays.toString(cs));
//        System.out.println(Arrays.toString(canReach));
//        System.out.println(Arrays.toString(waterCount));
        System.out.println(canReach[n + 1] &&
                (waterCount[n + 1] == Integer.MAX_VALUE || waterCount[n + 1] <= k)
                ? "YES" : "NO");
    }

}