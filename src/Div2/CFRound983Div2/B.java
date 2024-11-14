package Div2.CFRound983Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = 1;
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);

        if (n == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        } else if (n == 2) {
            System.out.println(-1);
            return;
        }
        int leftCount = k - 1, rightCount = n - k;
        if ((leftCount == 0 && (rightCount & 1) == 0) || rightCount == 0) {
            System.out.println(-1);
            return;
        }
        int minLeft = (leftCount & 1) == 0 ? 2 : 1, maxLeft = k - 1;
        int minRight = (rightCount & 1) == 0 ? 2 : 1, maxRight = n - k;
        if (minLeft > maxRight || maxLeft < minRight) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int count = Math.min(leftCount, rightCount);
        if ((leftCount & 1) == 1) {
            System.out.println(count * 2 + 1);
            for (int i = 1; i <= count; i++) {
                sb.append(i).append(" ");
            }
            sb.append(k).append(" ");
            for (int i = 1; i <= count; i++) {
                sb.append(i + k).append(" ");
            }
        } else {
            count = 2;
            System.out.println(5);
            for (int i = 1; i <= count; i++) {
                sb.append(i).append(" ");
            }
            sb.append(k).append(" ");
            for (int i = 1; i <= count; i++) {
                sb.append(i + k).append(" ");
            }
        }
        System.out.println(sb);
    }
}

