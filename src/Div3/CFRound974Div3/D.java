package Div3.CFRound974Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] ndk = br.readLine().split(" ");
        int n = Integer.parseInt(ndk[0]), d = Integer.parseInt(ndk[1]), k = Integer.parseInt(ndk[2]);

        Set<Integer>[] in = new Set[n + 1], out = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            in[i] = new HashSet<>();
            out[i] = new HashSet<>();
        }
        for (int i = 1; i <= k; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
            in[l].add(i);
            out[r].add(i);
        }

        int left = 1, right = 1;
        int first = 0, second = 0, fSize = 0, sSize = k + 1;
        Set<Integer> set = new HashSet<>();
        while (right <= n) {
            set.addAll(in[right]);
            if (right - left + 1 > d) {
                set.removeAll(out[left]);
                left++;
            }
            if (right - left + 1 == d) {
                if (set.size() > fSize) {
                    first = left;
                    fSize = set.size();
                }
                if (set.size() < sSize) {
                    second = left;
                    sSize = set.size();
                }
            }
            right++;
        }

        System.out.println(first + " " + second);
    }

}