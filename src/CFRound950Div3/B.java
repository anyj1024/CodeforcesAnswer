package CFRound950Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), f = Integer.parseInt(s[1]), k = Integer.parseInt(s[2]);
            String[] s1 = br.readLine().split(" ");
            Integer[] nums = new Integer[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }

            getAns(n, f, k, nums);
        }
    }

    private static void getAns(int n, int f, int k, Integer[] nums) {
        int val = nums[f - 1];
        Arrays.sort(nums, Collections.reverseOrder());
        if (nums[k - 1] > val) {
            System.out.println("NO");
        } else if (nums[k - 1] == val && (k <= n - 1 && nums[k] == val)) {
            System.out.println("MAYBE");
        } else {
            System.out.println("YES");
        }

    }
}
