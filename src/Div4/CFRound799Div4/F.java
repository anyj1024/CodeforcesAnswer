package Div4.CFRound799Div4;

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

    private static void solve() throws IOException{
        int n = Integer.parseInt(br.readLine());
        String[] s2 = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }

        int[] cnt = new int[10];
        for (int num : nums) {
            cnt[num % 10]++;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0) cnt[i]--;
            else continue;
            for (int j = 0; j < 10; j++) {
                if (cnt[j] > 0) cnt[j]--;
                else continue;
                for (int k = 0; k < 10; k++) {
                    if (cnt[k] > 0) cnt[k]--;
                    else continue;
                    if ((i + j + k) % 10 == 3) {
                        System.out.println("YES");
                        return;
                    }
                    cnt[k]++;
                }
                cnt[j]++;
            }
            cnt[i]++;
        }
        System.out.println("NO");
    }
}