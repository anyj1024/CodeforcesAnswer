package Div2.CFRound958Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        long n = Long.parseLong(br.readLine());
        char[] bits = Long.toBinaryString(n).toCharArray();
        int len = bits.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == '0') {
                set.add(i);
            }
        }
        List<Long> list = new ArrayList<>();
        list.add(bits2Long(bits));
        int last = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (bits[i] == '0') continue;
            bits[i] = '0';
            if (last != -1) {
                bits[last] = '1';
            }
            last = i;
            long cur = bits2Long(bits);
            if (cur == 0) break;
            list.add(bits2Long(bits));
        }

        Collections.reverse(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    private static long bits2Long(char[] bits) {
        int n = bits.length;

        long max = (long) Math.pow(2, n - 1), ans = 0;
        for (int i = 0; i < n; i++) {
            if (bits[i] == '1') {
                ans += max;
            }
            max /= 2;
        }

        return ans;
    }
}
