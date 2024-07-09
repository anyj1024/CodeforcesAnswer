package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long ans = 0;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]) - 1;
        }
        ans = 0;
        mergeSort(nums, 0, nums.length - 1);

        System.out.println(ans);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, index = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                temp[index++] = nums[p1++];
            } else {
                temp[index++] = nums[p2++];
                ans += mid - p1 + 1;
            }
        }
        while (p1 <= mid) temp[index++] = nums[p1++];
        while (p2 <= right) temp[index++] = nums[p2++];
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}