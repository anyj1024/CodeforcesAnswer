package Div4.CFRound835Div4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] ns = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }

        List<Integer> numbers = new ArrayList<>();
        int last = nums[0];
        numbers.add(last);
        for (int i = 1; i < n; i++) {
            if (nums[i] == last) continue;
            numbers.add(nums[i]);
            last = nums[i];
        }

        if (numbers.size() == 1) {
            System.out.println("YES");
            return;
        }

        int cnt = 0;
        if (numbers.get(1) > numbers.get(0)) cnt++;
        if (numbers.get(numbers.size() - 1) < numbers.get(numbers.size() - 2)) cnt++;
        for (int i = 1; i < numbers.size() - 1; i++) {
            int left = numbers.get(i - 1), right = numbers.get(i + 1);
            int mid = numbers.get(i);
            if (mid < left && mid < right) {
                cnt++;
            }
        }

        System.out.println(cnt > 1 ? "NO" : "YES");
    }

}