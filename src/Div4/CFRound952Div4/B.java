package Div4.CFRound952Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());

            getAns(n);
        }
    }

    private static void getAns(int n) {
        int max = Integer.MIN_VALUE, ans = 0;
        for (int i = 2; i <= n; i++) {
            int k = i, sum = 0;
            while (k <= n) {
                sum += k;
                k += i;
            }
            if (sum > max) {
                max = sum;
                ans = i;
            }
        }
        System.out.println(ans);
    }

}
