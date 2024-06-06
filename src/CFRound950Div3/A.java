package CFRound950Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        while (v-- != 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            char[] cs = br.readLine().toCharArray();

            getAns(n, m, cs);
        }
    }

    private static void getAns(int n, int k, char[] cs) {
        int[] cnt = new int[7];
        for (char ch : cs) {
            cnt[ch - 'A']++;
        }
        int ans = 0;
        for (int num : cnt) {
            ans += Math.max(0, k - num);
        }
        System.out.println(ans);
    }
}
