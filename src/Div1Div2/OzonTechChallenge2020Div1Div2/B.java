package Div1Div2.OzonTechChallenge2020Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String s = br.readLine();
        int n = s.length();

        int l = s.indexOf('('), r = s.lastIndexOf(')');
        List<Integer> list = new ArrayList<>();
        while (l < r && l != -1) {
            list.add(l + 1);
            list.add(r + 1);
            l = s.indexOf('(', l + 1);
            r = s.lastIndexOf(')', r - 1);
        }

        if (list.size() > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
            return;
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
