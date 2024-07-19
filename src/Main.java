import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] ncd = br.readLine().split(" ");
        int n = Integer.parseInt(ncd[0]), d = Integer.parseInt(ncd[2]);
        long c = Long.parseLong(ncd[1]);
        String[] ns = br.readLine().split(" ");
        Long[] nums = new Long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(ns[i]);
        }
        Arrays.sort(nums, Collections.reverseOrder());

        long left = 0, right = d + 2;
        long ans = 0;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if (check(nums, c, d, mid)) {
                left = mid;
                ans = left;
            } else {
                right = mid - 1;
            }
        }

        if (ans == 0) {
            System.out.println("Impossible");
        } else if (ans == d + 2) {
            System.out.println("Infinity");
        } else {
            System.out.println(ans - 1);
        }
    }

    private static boolean check(Long[] nums, long c, int d, long k) {
        long total = 0;
        for (int ind = 0; ind < d; ind++) {
            if (ind % k < nums.length) {
                total += nums[(int)(ind % k)];
            }
        }
        return total >= c;
    }
}