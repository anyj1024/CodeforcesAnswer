package Div4.CFRound944Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        String[] nkq = br.readLine().split(" ");
        int n = Integer.parseInt(nkq[0]), k = Integer.parseInt(nkq[1]), q = Integer.parseInt(nkq[2]);
        int[] as = new int[k + 1], bs = new int[k + 1];
        String[] a = br.readLine().split(" "), b = br.readLine().split(" ");
        for (int i = 1; i <= k; i++) {
            as[i] = Integer.parseInt(a[i - 1]);
            bs[i] = Integer.parseInt(b[i - 1]);
        }

        for (int i = 0; i < q; i++) {
            int d = Integer.parseInt(br.readLine());
            int left = 0, right = k;
            int ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (as[mid] <= d) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            long time = bs[ans];
            if (d > as[ans]) {
                int dis = d - as[ans];
                time += 1l * dis * (bs[ans + 1] - bs[ans]) / (as[ans + 1] - as[ans]);
            }
            System.out.print(time + " ");
        }
        System.out.println();

    }
}

