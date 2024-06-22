package Div4.CFRound784Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            boolean flag = true;
            int res1 = nums[0] & 1, res2 = nums[1] & 1;
            for (int i = 2; i < n; i += 2) {
                if ((nums[i] & 1) != res1) {
                    flag = false;
                    break;
                }
            }
            for (int i = 3; i < n; i += 2) {
                if ((nums[i] & 1) != res2) {
                    flag = false;
                    break;
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }
}
