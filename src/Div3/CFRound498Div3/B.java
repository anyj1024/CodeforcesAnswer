package Div3.CFRound498Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        Integer[][] nums = new Integer[n][2];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(input[i]);
            nums[i][1] = i;
        }

        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        for (int i = k; i < n; i++) {
            nums[i][0] = 0;
            nums[i][1] = n;
        }
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        int sum = 0, prev = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i != k - 1) {
                sb.append((nums[i][1] - prev)).append(" ");
            } else {
                sb.append((n - prev - 1)).append(" ");
            }
            prev = nums[i][1];
            sum += nums[i][0];
        }

        System.out.println(sum);
        System.out.println(sb.toString());
    }
}