package Div3.CFRound966Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) {
            char[] cs = br.readLine().toCharArray();
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Integer, Character> map2 = new HashMap<>();
            if (cs.length != n) {
                System.out.println("NO");
                continue;
            }
            boolean check = true;
            for (int j = 0; j < cs.length; j++) {
                char key = cs[j];
                int value = nums[j];
                if ((map1.containsKey(key) && map1.get(key) != value) || (map2.containsKey(value) && map2.get(value) != key)) {
                    System.out.println("NO");
                    check = false;
                    break;
                }

                map1.put(key, value);
                map2.put(value, key);
            }
            if (check) {
                System.out.println("YES");
            }
        }
    }
}