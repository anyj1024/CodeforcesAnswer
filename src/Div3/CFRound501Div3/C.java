package Div3.CFRound501Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        long m = Long.parseLong(nm[1]);
        long[][] nums = new long[n][2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(" ");
            nums[i][0] = Long.parseLong(ab[0]);
            sum += nums[i][0];
            nums[i][1] = Long.parseLong(ab[1]) - nums[i][0];
        }

        if (sum <= m) {
            System.out.println(0);
            return;
        }
        Arrays.sort(nums, (a, b) -> Long.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            sum += nums[i][1];
            if (sum <= m) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}
