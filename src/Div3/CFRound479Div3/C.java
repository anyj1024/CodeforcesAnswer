package Div3.CFRound479Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        Integer[] nums = new Integer[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        if (k == n) {
            System.out.println(nums[n - 1]);
            return;
        }

        if (k == 0) {
            if (nums[0] == 1) {
                System.out.println(-1);
            } else {
                System.out.println(nums[0] - 1);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (k == i + 1 && nums[i] < nums[i + 1]) {
                System.out.println(nums[i]);
                return;
            }
        }
        System.out.println(-1);
    }

}