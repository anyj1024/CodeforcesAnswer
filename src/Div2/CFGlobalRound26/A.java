package Div2.CFGlobalRound26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            getAns(n, nums);
        }
    }

    private static void getAns(int n, int[] nums) {
        int cnt = 0, number = nums[0];
        for (int num : nums) {
            if (number == num) {
                cnt++;
            }
        }
        if (cnt == n) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        int index = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) index = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == index) {
                sb.append("R");
            } else {
                sb.append("B");
            }
        }
        System.out.println(sb.toString());
    }
}
