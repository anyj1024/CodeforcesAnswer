package Div4.CFRound918Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] nums = new long[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(str[i]);
        }

        long sum = Arrays.stream(nums).sum();
        long length = (long) Math.sqrt(sum);
        if (length * length == sum) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

