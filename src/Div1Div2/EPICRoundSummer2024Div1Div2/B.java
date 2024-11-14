package Div1Div2.EPICRoundSummer2024Div1Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int max = nums[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (max - nums[i] > 0) pq.offer(max - nums[i]);
            max = Math.max(max, nums[i]);
        }

        int prev = 0;
        long ans = 0;
        while (!pq.isEmpty()) {
            int cost = pq.size() + 1, curr = pq.poll();
            ans += 1l * cost * (curr - prev);
            prev = curr;
        }
        System.out.println(ans);
    }
}
