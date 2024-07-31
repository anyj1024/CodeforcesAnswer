package Div2.EduRound168Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

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
        char[] s = br.readLine().toCharArray();

        int left = 0, right = 0;

        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
//            System.out.println(i + "  "  + stack.toString() + "   " + ans + "  " + left + "  " + right);
            if (s[i] == '(' || left <= right) {
                stack.offerLast(i);
                left++;
                continue;
            }
            if (s[i] == '_' && left > right) {
                s[i] = ')';
            }
            if (s[i] == ')') right++;
            ans += i - stack.pollLast();
        }
        System.out.println(ans);

    }
}