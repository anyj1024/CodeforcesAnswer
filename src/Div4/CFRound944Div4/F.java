package Div4.CFRound944Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }


    private static void solve() throws IOException {
        long r = Long.parseLong(br.readLine());
        long r1 = r * r, r2 = (r + 1) * (r + 1);
        int ans = 0;

        for (long i = 1; i <= r; i++) {
            long minY = (long) Math.ceil(Math.sqrt(r1 - i * i));
            long maxY = (long) Math.sqrt(r2 - i * i - 0.1);

            if (maxY >= minY) {
                ans += maxY - minY + 1;
            }
        }

        System.out.println(ans * 4);

    }
}

