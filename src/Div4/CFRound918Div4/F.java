package Div4.CFRound918Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long ans;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] ns = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]), b = Integer.parseInt(ab[1]);
            ns[i][0] = a;
            ns[i][1] = b;
        }

        Arrays.sort(ns, (a, b) -> a[0] - b[0]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ns[i][1];
        }

        ans = 0;
        mergeSort(nums, 0, n - 1);
        System.out.println(ans);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                ans += (mid - i + 1);
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, left, right - left + 1);
    }
}

