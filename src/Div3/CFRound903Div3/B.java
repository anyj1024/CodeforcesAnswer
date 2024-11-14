package Div3.CFRound903Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] abc = br.readLine().split(" ");
        long[] nums = new long[3];
        nums[0] = Long.parseLong(abc[0]);
        nums[1] = Long.parseLong(abc[1]);
        nums[2] = Long.parseLong(abc[2]);
        Arrays.sort(nums);
        long a = nums[0], b = nums[1], c = nums[2];

        if (a == b && b == c) {
            System.out.println("YES");
        } else if (a == b && c == 2 * a) {
            System.out.println("YES");
        } else if (a == b && c == 3 * a) {
            System.out.println("YES");
        } else if (b == c && 2 * a == b) {
            System.out.println("YES");
        } else if (a == b && 4 * a == c) {
            System.out.println("YES");
        } else if (a * 2 == b && 3 * a == c) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
