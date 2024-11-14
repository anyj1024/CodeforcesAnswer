package Div3.CFRound984Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        String[] nkq = br.readLine().split(" ");
        int n = Integer.parseInt(nkq[0]), k = Integer.parseInt(nkq[1]), q = Integer.parseInt(nkq[2]);

        long[][] b = new long[n][k];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                long a = Long.parseLong(line[j]);
                if (i == 0) {
                    b[i][j] = a;
                } else {
                    b[i][j] = b[i - 1][j] | a;
                }
            }
        }

        long[][] region = new long[k][n];
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < n; i++) {
                region[j][i] = b[i][j];
            }
        }

        for (int qq = 0; qq < q; qq++) {
            int m = Integer.parseInt(br.readLine());
            int maxLeft = 1;
            int minRight = n;

            for (int mm = 0; mm < m; mm++) {
                String[] query = br.readLine().split(" ");
                int r = Integer.parseInt(query[0]) - 1;
                long c = Long.parseLong(query[2]);
                String o = query[1];

                int l = 1, rIndex = n;

                if (o.equals("<")) {
                    int idx = getLeft(region[r], c);
                    minRight = Math.min(minRight, idx);
                } else if (o.equals(">")) {
                    int idx = getRight(region[r], c);
                    maxLeft = Math.max(maxLeft, idx + 1);
                }
                maxLeft = Math.max(maxLeft, l);
                minRight = Math.min(minRight, rIndex + 1);
            }

            if (maxLeft > minRight) {
                sb.append(-1).append("\n");
            } else {
                sb.append(maxLeft).append("\n");
            }
        }
    }

    private static int getRight(long[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int getLeft(long[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
