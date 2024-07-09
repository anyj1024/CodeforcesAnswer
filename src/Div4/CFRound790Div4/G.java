package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] nodes = new int[n - 1];
            String[] node = br.readLine().split(" ");
            for (int i = 0; i < n - 1; i++) {
                nodes[i] = Integer.parseInt(node[i]);
            }
            char[] colors = br.readLine().toCharArray();

            getAns(n, nodes, colors);
        }

    }

    private static void getAns(int n, int[] nodes, char[] colors) {
        int[] cnt = new int[n + 1];
        int ans = 0;
        for (int i = n; i > 0; i--) {
            if (colors[i - 1] == 'W') {
                cnt[i]++;
            } else {
                cnt[i]--;
            }
            if (cnt[i] == 0) {
                ans++;
            }
            if (i >= 2)
                cnt[nodes[i - 2]] += cnt[i];
        }
        System.out.println(ans);
    }
}