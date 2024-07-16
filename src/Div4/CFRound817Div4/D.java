package Div4.CFRound817Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[] cs = br.readLine().toCharArray();

        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int leftCount = i, rightCount = n - i - 1;
            ans += (cs[i] == 'L' ? leftCount : rightCount);
            if ((leftCount > rightCount && cs[i] == 'L')
                    || (leftCount < rightCount && cs[i] == 'R')) {
                continue;
            }
            pq.add(Math.abs(rightCount - leftCount));
        }

        while (n-- != 0) {
            if (pq.size() > 0) {
                ans += pq.poll();
            }
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}