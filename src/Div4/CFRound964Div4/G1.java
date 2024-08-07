package Div4.CFRound964Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int left = 2, right = 999;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("? 1 " + mid);
            int res = Integer.parseInt(br.readLine());

            if (res == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println("! " + left);
    }

}