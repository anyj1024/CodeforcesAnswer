package Div3.CFRound486Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();
        boolean found = true;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int key = s.length();
            if (!map.containsKey(key)) {
                map.put(key, new TreeMap<>());
            }
            map.get(key).put(s, map.get(key).getOrDefault(s, 0) + 1);
            if (map.get(key).size() > 1) {
                found = false;
            }
        }
        if (!found) {
            System.out.println("NO");
            return;
        }

        List<Map<String, Integer>> maps = new ArrayList<>(map.values());
        List<String> list = new ArrayList<>();
        for (Map<String, Integer> map1 : maps) {
            List<String> list1 = new ArrayList<>(map1.keySet());
            list.addAll(list1);
        }
        String last = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (!list.get(i).contains(last)) {
                System.out.println("NO");
                return;
            }
            last = list.get(i);
        }

        System.out.println("YES");
        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            Map<String, Integer> ss = entry.getValue();
            for (Map.Entry<String, Integer> s : ss.entrySet()) {
                String key = s.getKey();
                int value = s.getValue();
                for (int i = 0; i < value; i++) {
                    System.out.println(key);
                }
            }
        }

    }
}