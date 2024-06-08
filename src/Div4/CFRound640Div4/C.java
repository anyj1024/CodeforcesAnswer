package Div4.CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);

            getAns(n, k);
        }
    }

    private static void getAns(int n, int k) {
        System.out.println((k - 1) / (n - 1) + k);
    }
}
