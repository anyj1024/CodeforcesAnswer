package Div3.CFRound479Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Map<String, Integer> map = new HashMap<>();

        int frequency = 0;
        for (int i = 0; i < n - 1; i++) {
            String key = s.substring(i, i + 2);
            map.put(key, map.getOrDefault(key, 0) + 1);
            frequency = Math.max(frequency, map.get(key));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if (value == frequency) {
                System.out.println(key);
                return;
            }
        }
    }

}