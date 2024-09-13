package Div2.CFRound914Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        long k = Long.parseLong(nk[1]);
        Long[] nums = new Long[n];
        String[] numsStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(numsStr[i]);
        }

        if (k >= 3) {
            System.out.println(0);
            return;
        }

        Arrays.sort(nums);
        long ans = nums[0];

        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }
        if (k == 1) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long cur = nums[j] - nums[i];
                ans = Math.min(ans, cur);
                int index = binarySearch(nums, cur);
                if (index < n) {
                    ans = Math.min(ans, nums[index] - cur);
                }
                if (index > 0) {
                    ans = Math.min(ans, cur - nums[index - 1]);
                }
            }
        }
        System.out.println(ans);
    }

    private static int binarySearch(Long[] nums, long cur) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= cur) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}