package Div2.EduRound171Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(input[i - 1]);
        }

        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + a[i];
        }

        long[] prePreSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prePreSum[i] = prePreSum[i - 1] + preSum[i];
        }

        long[] start = new long[n + 2];
        start[1] = 1;
        for (int l = 2; l <= n + 1; l++) {
            start[l] = start[l - 1] + (n - (l - 1) + 1);
        }

        long[] sum = new long[n + 1];
        for (int l = 1; l <= n; l++) {
            sum[l] = prePreSum[n] - prePreSum[l - 1] - (long)(n - l + 1) * preSum[l - 1];
        }

        long[] sumSum = new long[n + 1];
        for (int l = 1; l <= n; l++) {
            sumSum[l] = sumSum[l - 1] + sum[l];
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            long left = Long.parseLong(lr[0]), right = Long.parseLong(lr[1]);

            long ans = getRes(right, start, preSum, prePreSum, sumSum, n) - getRes(left - 1, start, preSum, prePreSum, sumSum, n);
            System.out.println(ans);
        }
    }

    public static long getRes(long pos, long[] start, long[] preSum, long[] prePreSum, long[] sumSum, int n) {
        if (pos < 1) return 0;
        int leftPos = binarySearch(start, pos);
        long rightPos = pos - start[leftPos] + leftPos;
        if (rightPos > n) rightPos = n;
        long sumUpToLpMinus1 = (leftPos - 1 >= 0) ? sumSum[leftPos - 1] : 0;

        long part = prePreSum[(int) rightPos] - prePreSum[leftPos - 1] - (rightPos - leftPos + 1) * preSum[leftPos - 1];
        return sumUpToLpMinus1 + part;
    }

    public static int binarySearch(long[] start, long pos){
        int left = 1;
        int right = start.length - 2;
        int res = 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(start[mid] <= pos){
                res = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return res;
    }
}
