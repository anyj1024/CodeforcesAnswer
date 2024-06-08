package Div4.CFRound640Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {

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
        int[] cnt = new int[8001];
        for (int num : nums) {
            cnt[num]++;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int preSum = nums[i];
            for (int j = i + 1; j < n; j++) {
                preSum += nums[j];
                if (preSum > 8000) break;
//                System.out.println("preSum " + preSum);
                ans += cnt[preSum];
                cnt[preSum] = 0;
            }
        }

        System.out.println(ans);
    }
}
