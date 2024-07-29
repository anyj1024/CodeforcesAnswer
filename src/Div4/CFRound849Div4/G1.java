package Div4.CFRound849Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]), c = Integer.parseInt(nc[1]);
        Integer[] nums = new Integer[n + 1];
        nums[0] = 0;
        String[] ns = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(ns[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            nums[i] += i;
        }
        Arrays.sort(nums);
        long sum = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + nums[i] <= c) {
                sum += nums[i];
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }
}