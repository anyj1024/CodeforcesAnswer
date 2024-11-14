package Div1Div2.CFRound947Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(nums);
        int val1 = nums[0], val2 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % val1 == 0) continue;
            val2 = nums[i];
            break;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] % val1 != 0 && nums[i] % val2 != 0) {
                sb.append("NO").append("\n");
                return;
            }
        }

        sb.append("YES").append("\n");
    }
}