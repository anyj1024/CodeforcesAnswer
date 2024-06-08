package Div4.CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            List<Integer> ans = getAns(Integer.parseInt(br.readLine()));

            System.out.println(ans.size());
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static List<Integer> getAns(int n) {
        List<Integer> ans = new ArrayList<>();
        int digit = 0;
        while (n != 0) {
            if (n % 10 != 0) {
                ans.add((n % 10) * (int) Math.pow(10, digit));
            }
            digit++;
            n /= 10;
        }
        return ans;
    }
}
