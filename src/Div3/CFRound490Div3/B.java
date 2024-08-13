package Div3.CFRound490Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = new char[n + 1];
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            cs[i + 1] = input[i];
        }

        List<Integer> factors = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                factors.add(n / i);
            }
        }

        for (int factor : factors) {
            reverse(cs, 1, factor);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(cs[i]);
        }
        System.out.println();
    }

    private static void reverse(char[] cs, int left, int right) {
        while (left <= right) {
            char temp = cs[left];
            cs[left] = cs[right];
            cs[right] = temp;
            left++;
            right--;
        }
    }
}