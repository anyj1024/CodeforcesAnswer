package Div3.CFRound981Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        long ans = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (nums[i] == i + 1) {
                visited[i] = true;
                continue;
            }

            int cur = 0, j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = nums[j] - 1;
                cur++;
            }

            if (cur > 1) {
                ans += (cur - 1) / 2;
            }
        }

        System.out.println(ans);
    }

}