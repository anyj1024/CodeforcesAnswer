package Div2.EduRound171Div2;

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
        int[] nums = new int[n + 1];
        char[] cs = br.readLine().toCharArray();

        for (int i = 1; i <= n; i++) {
            nums[i] = cs[i - 1] - '0';
        }
        long ans = 0, count = 0;
        for (int i = n; i >= 1; i--) {
            if (nums[i] == 1) {
                if (count < i - 1) {
                    count++;
                } else {
                    ans += i;
//                    System.out.println("delta : " + i);
                }
            } else {
                if (count >= 1) count--;
                ans += i;
//                System.out.println("delta : " + i);
            }
        }
        System.out.println(ans);
    }
}
