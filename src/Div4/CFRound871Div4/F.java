package Div4.CFRound871Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class F {
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
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            String[] uv = br.readLine().split(" ");
            int u = Integer.parseInt(uv[0]), v = Integer.parseInt(uv[1]);
            inDegree[u]++;
            inDegree[v]++;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] != 1) {
                map.put(inDegree[i], map.getOrDefault(inDegree[i], 0) + 1);
            }
        }
        int firstKey = map.firstKey(), lastKey = map.lastKey();
        int firstCount = map.get(firstKey), lastCount = map.get(lastKey);

        if (firstKey == lastKey) {
            System.out.println(firstKey + " " + (firstKey - 1));
        } else {
            if (firstCount > lastCount) {
                System.out.println(lastKey + " " + (firstKey - 1));
            } else {
                System.out.println(firstKey + " " + (lastKey - 1));
            }
        }

    }
}