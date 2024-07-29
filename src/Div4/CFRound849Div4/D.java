package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : cs) map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        int ans = map1.size();
        for (int i = 0; i < n; i++) {
            char ch = cs[i];
            map1.put(cs[i], map1.getOrDefault(ch, 0) - 1);
            if (map1.get(ch) == 0) map1.remove(ch);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
            ans = Math.max(ans, map2.size() + map1.size());
        }
        System.out.println(ans);
    }
}