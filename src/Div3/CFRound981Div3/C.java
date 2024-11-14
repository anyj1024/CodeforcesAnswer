package Div3.CFRound981Div3;

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

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int left = n / 2 - 1, right = ((n & 1) == 1) ? n / 2 + 1 : n / 2;
        while (left >= 0) {
            if (nums[left] != nums[right]) {
                if (nums[left] == nums[left + 1]) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                } else if (nums[right] == nums[right - 1]) {
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                }
            }
            left--;
            right++;
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}