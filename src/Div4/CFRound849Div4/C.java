package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        char[] cs = br.readLine().toCharArray();
        int count = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (cs[left] != cs[right]) {
                count++;
                left++;
                right--;
            } else {
                break;
            }
        }

        System.out.println(n - count * 2);
    }
}