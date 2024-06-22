package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int key = Integer.parseInt(input[i]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            int ans = Integer.MIN_VALUE;
            for (int key : map.keySet()) {
                if (map.get(key) >= 3) {
                    ans = key;
                }
            }

            System.out.println(ans == Integer.MIN_VALUE ? -1 : ans);
        }
    }
}