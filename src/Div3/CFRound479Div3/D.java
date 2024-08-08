package Div3.CFRound479Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] nums = new long[n][3];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(input[i]);
            nums[i][0] = value;
            int cnt1 = 0, cnt2 = 0;
            while (value % 3 == 0) {
                cnt1++;
                value /= 3;
            }
            while (value % 2 == 0) {
                cnt2++;
                value /= 2;
            }
            nums[i][1] = cnt1;
            nums[i][2] = cnt2;
        }

        Arrays.sort(nums, (a, b) -> (a[1] != b[1]) ? Long.compare(b[1], a[1]) : Long.compare(a[2], b[2]));
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i][0] + " ");
        }
        System.out.println();
    }

}