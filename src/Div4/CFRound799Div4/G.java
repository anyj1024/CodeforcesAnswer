package Div4.CFRound799Div4;

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

    private static void solve() throws IOException{
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
        long[] nums = new long[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(s1[i]);
        }

        int[] vals = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] * 2 > nums[i]) {
                vals[i] = 1;
            }
        }
//        System.out.println(Arrays.toString(vals));
        int left = 0, right = 0;
        int ans = 0, sum = 0;
        while (right < vals.length) {
            sum += vals[right];
            if (right - left + 1 == k) {
                if (sum == k) {
                    ans++;
                }
                sum -= vals[left];
                left++;
            }
            right++;
        }
        System.out.println(ans);
    }

}
