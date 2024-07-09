package Div4.CFRound790Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]) - 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1  = i, x2 = j, y1 = nums[i], y2 = nums[j];
                if ((x1 >= x2 && y1 <= y2) || (x2 >= x1 && y2 <= y1)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}