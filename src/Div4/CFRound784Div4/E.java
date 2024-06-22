package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            char[][] cs = new char[n][2];
            for (int i = 0; i < n; i++) {
                cs[i] = br.readLine().toCharArray();
            }

            getAns(cs);
        }
    }

    private static void getAns(char[][] cs) {
        long ans = 0, n = cs.length;
        Map<Character, Integer> prefix = new HashMap<>(), suffix = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char pre = cs[i][0], suf = cs[i][1];
            String s = new String(cs[i]);
            ans += prefix.getOrDefault(pre, 0) + suffix.getOrDefault(suf, 0) - 2 * map.getOrDefault(s, 0);
//            System.out.println("count  " + ans);
            prefix.put(pre, prefix.getOrDefault(pre, 0) + 1);
            suffix.put(suf, suffix.getOrDefault(suf, 0) + 1);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(ans);
    }
}