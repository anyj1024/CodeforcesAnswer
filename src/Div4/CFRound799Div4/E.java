package Div4.CFRound799Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }

    }

    private static void solve() throws IOException{
        String[] s1 = br.readLine().split(" "), s2 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]), s = Integer.parseInt(s1[1]);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s2[i]);
        }

        int sum = Arrays.stream(nums).sum();
        if (sum < s) {
            System.out.println(-1);
            return;
        } else if (sum == s) {
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                list.add(i);
//                System.out.print(list.get(list.size() - 1) + " ");
            }
        }
        int ans = n;
        for (int i = 0; i + s - 1 < list.size(); i++) {
            if (i + s - 1 == list.size() - 1) {
                ans = Math.min(ans, list.get(i - 1) + 1);
            } else if (i == 0) {
                ans = Math.min(ans, n - list.get(i + s));
            } else {
                ans = Math.min(ans, n - 1 - list.get(i + s) + 1 + list.get(i - 1) - 0 + 1);
            }
        }
        System.out.println(ans);
    }
}