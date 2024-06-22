package Div4.CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            getAns(n);
        }
    }

    private static void getAns(int n) {
        if (n <= 3) {
            System.out.println(-1);
            return;
        }

        int left = n % 2 == 0 ? n - 1 : n, right = 6;
        while (left > 0) {
            System.out.print(left + " ");
            left -= 2;
        }
        System.out.print(4 + " " + 2 + " ");
        while (right <= n) {
            System.out.print(right + " ");
            right += 2;
        }
        System.out.println();
    }
}