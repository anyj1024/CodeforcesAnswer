package Div4.CFRound944Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        String s = br.readLine();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (list.size() == 0 || list.get(list.size() - 1) != s.charAt(i)) {
                list.add(s.charAt(i));
            }
        }

        int ans = list.size();
        if (list.size() > 2 || (list.size() == 2 && list.get(0) == '0')) ans--;
        System.out.println(ans);
    }
}

