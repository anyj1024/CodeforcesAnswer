package Div4.CFRound817Div4;

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

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s1 = br.readLine().split(" ");
        String[] s2 = br.readLine().split(" ");
        String[] s3 = br.readLine().split(" ");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s1[i], map.getOrDefault(s1[i], 0) + 1);
            map.put(s2[i], map.getOrDefault(s2[i], 0) + 1);
            map.put(s3[i], map.getOrDefault(s3[i], 0) + 1);
        }

        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(s1[i]) == 1) n1 += 3;
            else if (map.get(s1[i]) == 2) n1 += 1;
            if (map.get(s2[i]) == 1) n2 += 3;
            else if (map.get(s2[i]) == 2) n2 += 1;
            if (map.get(s3[i]) == 1) n3 += 3;
            else if (map.get(s3[i]) == 2) n3 += 1;
        }

        System.out.println(n1 + " " + n2 + " " + n3);
    }
}