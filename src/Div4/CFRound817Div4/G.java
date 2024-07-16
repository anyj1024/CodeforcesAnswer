package Div4.CFRound817Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int xor = 0;
        for (int i = 0; i < n - 3; i++) {
            sb.append(i + " ");
            xor ^= i;
        }
        int x = 1 << 25, y = 1 << 26;
        sb.append(xor ^ x ^ y).append(" ").append(x + " ").append(y);
        System.out.println(sb.toString());
    }
}