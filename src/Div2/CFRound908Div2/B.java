package Div2.CFRound908Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
//        int t = 1;
        while (t-- != 0) {
            solve();
        }
        System.out.print(sb);
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] nums = new int[n];
        int[] map = new int[101];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
            map[nums[i]]++;
        }

        int count = 0, val1 = -1, val2 = -1;
        for (int i = 1; i <= 100; i++) {
            if (map[i] >= 2) {
                count++;
                if (val1 == -1) {
                    val1 = i;
                } else {
                    val2 = i;
                }
            }
        }

        if (count < 2) {
            sb.append(-1).append("\n");
            return;
        }
        boolean f1 = false, f2 = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val1 && nums[i] != val2) {
                sb.append(1).append(" ");
            } else if (nums[i] == val1) {
                if (!f1) {
                    f1 = true;
                    sb.append(1).append(" ");
                } else {
                    sb.append(2).append(" ");
                }
            } else if (nums[i] == val2) {
                if (!f2) {
                    f2 = true;
                    sb.append(1).append(" ");
                } else {
                    sb.append(3).append(" ");
                }
            }
        }
        sb.append("\n");
    }
}