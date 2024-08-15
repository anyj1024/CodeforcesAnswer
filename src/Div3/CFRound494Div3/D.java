package Div3.CFRound494Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
//        int t = Integer.parseInt(br.readLine());
        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]), q = Integer.parseInt(nq[1]);
        long[] nums = new long[n];
        String[] numsStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(numsStr[i]);
        }

        int[] cnt = new int[32];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 31; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    cnt[j]++;
                }
            }
        }

//        System.out.println(Arrays.toString(cnt));
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
//            if ((query & 1) != 0) {
//                System.out.println(-1);
//                break;
//            }

            int[] now = new int[32];
            for (int j = 0; j <= 31; j++) {
                if ((query & (1 << j)) != 0) {
                    now[j]++;
                }
            }

            long ans = 0, cur = 0;
            for (int j = 31; j >= 0; j--) {
                cur = cur * 2 + now[j];
                if (cnt[j] > 0) {
                    ans += Math.min(cnt[j], cur);
                    cur = cur - Math.min(cnt[j], cur);
                }
            }

            System.out.println(cur == 0 ? ans : -1);
        }
    }
}