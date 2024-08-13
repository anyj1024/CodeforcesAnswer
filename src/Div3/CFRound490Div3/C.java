package Div3.CFRound490Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        char[] cs = br.readLine().toCharArray();
        int[] cnt = new int[26];
        for (int i = 0; i < cs.length; i++) {
            cnt[cs[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (k > cnt[i]) {
                k -= cnt[i];
            } else {
                cnt[i] = k;
                k = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cnt[cs[i] - 'a'] > 0) {
                cnt[cs[i] - 'a']--;
                continue;
            }
            sb.append(cs[i]);
        }
        System.out.println(sb);
    }
}