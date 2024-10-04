package Div2.CFRound948Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        long x = Long.parseLong(br.readLine());

        int[] ans = new int[32];
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & x) != 0) {
                ans[i] = 1;
            }
        }
        while (check(ans)) {
            for (int i = 0; i < 32; i++) {
                if (ans[i] == 0) continue;
                int len = 0;
                for (int j = i; j < 32; j++) {
                    if (ans[j] == 1) {
                        len++;
                    } else {
                        break;
                    }
                }
//                System.out.println(len);
                if (len > 1) {
                    ans[i] = -1;
                    for (int j = i + 1; j < i + len; j++) {
                        ans[j] = 0;
                    }
                    ans[i + len] = 1;
                }
                i += len;
            }
        }

//        System.out.println(Arrays.toString(ans));
        int last = 0;
        for (int i = 1; i < 32; i++) {
            if (ans[i] != 0) last = i;
            int l = ans[i - 1], r = ans[i];
            if (l == 1 && r == -1) {
                ans[i - 1] = -1;
                ans[i] = 0;
            } else if (l == -1 && r == 1) {
                ans[i - 1] = 1;
                ans[i] = 0;
            }
        }
//        System.out.println(Arrays.toString(ans));
        System.out.println(last + 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= Math.min(31, last); i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean check(int[] ans) {
        for (int i = 0; i < 32; i++) {
            if (ans[i] == 0) continue;
            int len = 0;
            for (int j = i; j < 32; j++) {
                if (ans[j] == 1) {
                    len++;
                } else {
                    break;
                }
            }
            if (len > 1) {
                return true;
            }
        }
        return false;
    }
}