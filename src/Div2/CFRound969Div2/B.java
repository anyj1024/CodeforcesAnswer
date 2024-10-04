package Div2.CFRound969Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public static void main(String[] args) throws IOException {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                solve();
            }
        }

        private static void solve() throws IOException {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
            int[] nums = new int[n];
            String[] input = br.readLine().split(" ");
            int max = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(input[i]);
                max = Math.max(max, nums[i]);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                String[] clr = br.readLine().split(" ");
                String type = clr[0];
                int left = Integer.parseInt(clr[1]), right = Integer.parseInt(clr[2]);

                if (left <= max && right >= max) {
                    if (type.equals("+")) {
                        max++;
                        sb.append(max).append(" ");
                    } else {
                        max--;
                        sb.append(max).append(" ");
                    }
                } else {
                    sb.append(max).append(" ");
                }
            }

            System.out.println(sb);
        }
    }