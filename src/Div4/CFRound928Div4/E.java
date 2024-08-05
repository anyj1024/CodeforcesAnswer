package Div4.CFRound928Div4;

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
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]), k = Integer.parseInt(nk[1]);
        int ans = 1, cnt = 0, pos = 1;
        while (true) {
            int sum = ((n - ans) >> pos) + 1;
            if (cnt + sum < k) {
                pos++;
                cnt += sum;
                ans *= 2;
            } else {
                ans += (k - cnt - 1) << pos;
                break;
            }
        }
        System.out.println(ans);
    }
}

