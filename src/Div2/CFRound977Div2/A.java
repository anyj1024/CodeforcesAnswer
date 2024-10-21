package Div2.CFRound977Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class A {
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
        Long[] nums = new Long[n];
        String[] input = br.readLine().split(" ");

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(input[i]));
        }

        while (pq.size() > 1) {
            long x = pq.poll(), y = pq.poll();
            pq.offer((x + y) / 2);
        }

        System.out.println(pq.poll());

    }

}