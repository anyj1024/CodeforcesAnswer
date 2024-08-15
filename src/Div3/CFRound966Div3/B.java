package Div3.CFRound966Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(input[i - 1]);
        }

        Set<Integer> set = new HashSet<>();
        boolean check = true;
        for (int i = 1; i <= n; i++) {
            if (set.size() == 0 || set.contains(nums[i])) {
                set.add(nums[i] + 1);
                set.add(nums[i] - 1);
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}