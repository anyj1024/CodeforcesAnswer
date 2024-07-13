package Div4.CFRound799Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        String[] input = br.readLine().split(" ");
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int ans = 0;
        for (int i = 1; i < 4; i++) {
            if (nums[i] > nums[0]) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}
