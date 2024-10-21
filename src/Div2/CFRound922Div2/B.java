package Div2.CFRound922Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" "), input2 = br.readLine().split(" ");
        Integer[][] nums = new Integer[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = Integer.parseInt(input1[i]);
            nums[i][1] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append(nums[i][0]).append(" ");
            sb2.append(nums[i][1]).append(" ");
        }

        System.out.println(sb1);
        System.out.println(sb2);
    }
}