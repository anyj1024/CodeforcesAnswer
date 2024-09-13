package Div3.CFRound970Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String[] lr = br.readLine().split(" ");
        int l = Integer.parseInt(lr[0]), r = Integer.parseInt(lr[1]);
        int delta = r - l;
        long cur = 0;
        while (cur * (cur + 1) <= 2l * delta) {
            cur++;
        }

        System.out.println(cur);
    }
}