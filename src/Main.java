import java.util.*;
import java.io.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]), p = a, k = 0;
        for (int i = 1; i < n; i++) {
            int b = Integer.parseInt(s[i]);
            if (a > b) k++;
            a = b;
        }
        System.out.println((k > 1 || (k == 1 && a > p)) ? "NO" : "YES");
    }
}