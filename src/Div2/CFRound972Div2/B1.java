package Div2.CFRound972Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nmq = br.readLine().split(" ");
        int n = Integer.parseInt(nmq[0]), m = Integer.parseInt(nmq[1]), q = Integer.parseInt(nmq[2]);
        String[] in1 = br.readLine().split(" ");
        Integer[] nums = new Integer[m];
        for (int i = 0; i < m; i++) nums[i] = Integer.parseInt(in1[i]);
        String[] in2 = br.readLine().split(" ");
        int[] nums2 = new int[q];
        for (int i = 0; i < q; i++) nums2[i] = Integer.parseInt(in2[i]);

        Arrays.sort(nums);
        for (int query : nums2) {
            int left = binarySearchLeft(nums, query), right = binarySearchRight(nums, query);
            if (left == -1) {
                System.out.println(right - 1);
            } else if (right == -1) {
                System.out.println(n - left);
            } else {
                System.out.println((right - left) / 2);
            }
        }

    }

    private static int binarySearchLeft(Integer[] nums, int query) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= query) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans == -1 ? -1 : nums[ans];
    }

    private static int binarySearchRight(Integer[] nums, int query) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= query) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans == -1 ? -1 : nums[ans];
    }

}