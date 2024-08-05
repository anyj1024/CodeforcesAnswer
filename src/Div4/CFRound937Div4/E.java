package Div4.CFRound937Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int ans = -1;
        for (int i = 1; i < n; i++) {
            if (n % i != 0) continue;
            boolean found = true;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j += i) {
                String sub = s.substring(j, j + i);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if (map.size() > 2) {
                    found = false;
                    break;
                }
            }
            if (!found) continue;
            if (map.size() == 1) {
                ans = i;
                break;
            }

            int count = 0;
            for (int num : map.values()) {
                if (num > 1) count++;
            }
            if (count > 1) continue;
            List<String> list = new ArrayList<>(map.keySet());
            String s1 = list.get(0), s2 = list.get(1);
            int cnt = 0;
            for (int k = 0; k < s1.length(); k++) {
                if (s1.charAt(k) != s2.charAt(k)) {
                    cnt++;
                    if (cnt > 1) break;
                }
            }

            if (cnt <= 1) {
                ans = i;
                break;
            }
        }
        System.out.println(ans == -1 ? n : ans);
    }
}

