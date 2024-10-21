package Div2.CFRound852Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(input[i - 1]);
        }

        int min = 1, max = n;
        int left = 1, right = n;
        while (left < right) {
            if (nums[left] == min) {
                min++;
                left++;
            } else if (nums[right] == max) {
                max--;
                right--;
            } else if (nums[left] == max) {
                max--;
                left++;
            } else if (nums[right] == min) {
                min++;
                right--;
            } else {
                System.out.println(left + " " + right);
                return;
            }
        }
        System.out.println(-1);
    }
}
