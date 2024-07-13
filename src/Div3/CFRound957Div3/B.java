package Div3.CFRound957Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        String[] s1 = br.readLine().split(" "), s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), k = Integer.parseInt(s1[1]);
        Integer[] a = new Integer[k];
        for (int i = 0; i < k; i++) {
            a[i] = Integer.parseInt(s2[i]);
        }
        Arrays.sort(a);

        long ans = 0;
        for (int i = 0; i < k - 1; i++) {
            ans += 2 * a[i] - 1;
        }

        System.out.println(ans);
    }

}