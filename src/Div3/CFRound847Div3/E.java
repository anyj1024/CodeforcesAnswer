package Div3.CFRound847Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        long n = Long.parseLong(br.readLine());
        if ((n & 1) == 1) {
            System.out.println(-1);
            return;
        }
        int[] nums = new int[65];
        long index = 1, number = n;
        while (n != 0) {
            long temp = Long.lowestOneBit(n);
            nums[(int) index] = (int) temp;
            index++;
            n -= temp;
        }

        for (int k = 1; k < index - 1; k++) {
            if (nums[k + 1] / nums[k] < 4) {
                System.out.println(-1);
                return;
            }
        }

        long b = 0;
        for (int k = 1; k <= index - 1; k++) {
            b += nums[k] / 2;
        }

        long a = number * 2 - b;

        System.out.println(a + " " + b);
    }
}