package Div4.CFRound944Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        char[] cs = br.readLine().toCharArray();
        int n = cs.length;
        int[] cnt = new int[26], last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            char ch = cs[i];
            cnt[ch - 'a']++;
            last[ch - 'a'] = i;
            if (cnt[ch - 'a'] == n) {
                System.out.println("NO");
                return;
            }
        }

        int i1 = -1, i2 = -1;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1 && i1 == -1) {
                i1 = last[i];
            } else if (last[i] != -1 && i2 == -1) {
                i2 = last[i];
                break;
            }
        }

        char t = cs[i1];
        cs[i1] = cs[i2];
        cs[i2] = t;
        System.out.println("YES");
        System.out.println(new String(cs));
    }
}

